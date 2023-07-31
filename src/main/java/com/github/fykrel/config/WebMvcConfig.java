package io.github.fykrel.config;

import io.github.fykrel.interceptors.TenantInterceptor;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * mvc配置
 *
 * @author fangyk
 * @date 2023年07月27日 14:45
 */
@Import(TenantInterceptor.class)
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private TenantInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 增加租户拦截器
        registry.addInterceptor(tenantInterceptor);
    }
}