package io.github.fykrel.interfaces;

import io.github.fykrel.domain.TenantDataSource;

import java.util.List;

/**
 * 数据源接口
 *
 * @author fangyk
 * @date 2023年07月28日 10:40
 */
public interface TenantDataSourceService {
    /**
     * 查询数据库配置数据
     *
     * @return {@link List< TenantDataSource >}
     */
    List<TenantDataSource> getDataSources();
}