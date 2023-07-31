package io.github.fykrel.config;

import io.github.fykrel.config.properties.PrimaryDataSourceProperties;
import io.github.fykrel.datasource.DynamicDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 动态数据源配置类
 *
 * @author fangyk
 * @date 2023年07月31日 14:27
 */
public class DynamicDataSourceConfig {
    /**
     * 默认数据源
     *
     * @return 默认数据源
     */
    @Bean
    @Primary
    public DataSource primaryDataSource(PrimaryDataSourceProperties properties) {
        return DataSourceBuilder.create()
                .username(properties.getUsername())
                .password(properties.getPassword())
                .url(properties.getUrl())
                .driverClassName(properties.getDriverClassName())
                .type(properties.getType())
                .build();
    }

    /**
     * 配置默认数据源
     *
     * @param primaryDataSource 默认数据源
     * @return {@link DynamicDataSource}
     */
    @Bean
    public DataSource dynamicDataSource(DataSource primaryDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        dynamicDataSource.setPrimaryDataSource(primaryDataSource);

        return dynamicDataSource;
    }
}