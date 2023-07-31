package io.github.fykrel.config;

import io.github.fykrel.config.properties.PrimaryDataSourceProperties;
import io.github.fykrel.config.properties.TenantProperties;
import io.github.fykrel.runner.DataSourceRunner;
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
@Import({io.github.fykrel.config.DynamicDataSourceConfig.class, io.github.fykrel.config.MybatisPlusConfig.class, DataSourceRunner.class, io.github.fykrel.config.WebMvcConfig.class})
public class AutoConfiguration {
}