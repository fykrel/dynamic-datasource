package com.github.fykrel.config;

import com.github.fykrel.config.properties.PrimaryDataSourceProperties;
import com.github.fykrel.config.properties.TenantProperties;
import com.github.fykrel.runner.DataSourceRunner;
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
@Import({com.github.fykrel.config.DynamicDataSourceConfig.class, com.github.fykrel.config.MybatisPlusConfig.class, DataSourceRunner.class, com.github.fykrel.config.WebMvcConfig.class})
public class AutoConfiguration {
}