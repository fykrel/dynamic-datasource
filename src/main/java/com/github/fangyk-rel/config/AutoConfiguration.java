package com.fangyk.config;

import com.fangyk.config.properties.PrimaryDataSourceProperties;
import com.fangyk.config.properties.TenantProperties;
import com.fangyk.runner.DataSourceRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动配置
 *
 * @author fangyk
 * @date 2023年07月28日 14:21
 */
@Configuration
@EnableConfigurationProperties({TenantProperties.class, PrimaryDataSourceProperties.class})
@Import({com.fangyk.config.DynamicDataSourceConfig.class, com.fangyk.config.MybatisPlusConfig.class, DataSourceRunner.class, com.fangyk.config.WebMvcConfig.class})
public class AutoConfiguration {
}