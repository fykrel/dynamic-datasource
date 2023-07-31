package com.fangyk.datasource;

import com.fangyk.config.properties.TenantProperties;
import com.fangyk.domain.TenantDataSource;
import com.fangyk.support.TenantThreadLocalHolder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据源
 *
 * @author fangyk
 * @date 2023年07月27日 16:03
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Resource
    private TenantProperties tenantProperties;

    /**
     * 数据源
     */
    private static final Map<Object, Object> DATA_SOURCE_MAP = new HashMap<>(1024);

    @Override
    protected Object determineCurrentLookupKey() {
        Object tenantId = TenantThreadLocalHolder.getTenantId();

        // null认为是主库, 使用默认数据源
        if (null == tenantId) {
            return null;
        }

        if (!DATA_SOURCE_MAP.containsKey(tenantId)) {
            throw new RuntimeException("No matching data source was found");
        }

        return tenantId;
    }

    /**
     * 设置默认数据源
     *
     * @param dataSource 数据源
     */
    public void setPrimaryDataSource(DataSource dataSource) {
        setDefaultTargetDataSource(dataSource);
        DATA_SOURCE_MAP.put("primaryDataSource", dataSource);
        afterSetDataSource();
    }

    /**
     * 新增数据源
     *
     * @param key        数据源key(租户ID)
     * @param dataSource 数据源
     */
    public void addDataSource(String key, DataSource dataSource) {
        DATA_SOURCE_MAP.put(key, dataSource);
        afterSetDataSource();
    }

    /**
     * 移除数据源
     *
     * @param key 数据源key(租户ID)
     */
    public void removeDataSource(String key) {
        DATA_SOURCE_MAP.remove(key);
        afterSetDataSource();
    }

    /**
     * 设置数据源
     */
    private void afterSetDataSource() {
        setTargetDataSources(DATA_SOURCE_MAP);
        afterPropertiesSet();
    }

    /**
     * 初始化数据源
     *
     * @param tenantDataSources 租户数据库配置
     */
    public void initDataSources(List<TenantDataSource> tenantDataSources) {
        if (null == tenantDataSources || tenantDataSources.isEmpty()) {
            return;
        }

        for (TenantDataSource tenantDataSource : tenantDataSources) {
            DATA_SOURCE_MAP.put(tenantDataSource.getTenantId().toString(), parse(tenantDataSource));
        }

        afterSetDataSource();
    }

    /**
     * 租户数据库配置转{@link DataSource}
     *
     * @param tenantDataSource 租户数据库配置
     * @return {@link DataSource}
     */
    public DataSource parse(TenantDataSource tenantDataSource) {
        HikariDataSource dataSource = new HikariDataSource();
        // 拼接数据库链接
        String jdbcUrl = tenantDataSource.getHost() + tenantDataSource.getBiz() + tenantProperties.getTenantSeparator() + tenantDataSource.getTenantId() + tenantDataSource.getParams();

        dataSource.setDriverClassName(tenantDataSource.getDriver());
        dataSource.setUsername(tenantDataSource.getUsername());
        dataSource.setPassword(tenantDataSource.getPassword());
        dataSource.setJdbcUrl(jdbcUrl);

        // 初始化数据源
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dataSource;
    }
}