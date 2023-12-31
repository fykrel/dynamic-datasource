package io.github.fykrel.runner;

import io.github.fykrel.interfaces.TenantDataSourceService;
import io.github.fykrel.datasource.DynamicDataSource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.annotation.Resource;

/**
 * 初始化数据源
 *
 * @author fangyk
 * @date 2023年07月28日 10:57
 */
public class DataSourceRunner implements ApplicationRunner {
    @Resource
    private DynamicDataSource dynamicDataSource;
    @Resource
    private TenantDataSourceService tenantDataSourceService;

    @Override
    public void run(ApplicationArguments args) {
        dynamicDataSource.initDataSources(tenantDataSourceService.getDataSources());
    }
}
