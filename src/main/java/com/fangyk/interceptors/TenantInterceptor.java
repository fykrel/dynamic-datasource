package com.fangyk.interceptors;

import com.fangyk.config.properties.TenantProperties;
import com.fangyk.support.TenantThreadLocalHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于设置租户ID
 *
 * @author fangyk
 * @date 2023年07月27日 14:47
 */
@Component
public class TenantInterceptor implements HandlerInterceptor {
    @Resource
    private TenantProperties tenantProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 租户ID
        String tenantId = request.getHeader(tenantProperties.getTenantFieldName());

        TenantThreadLocalHolder.setTenantId(tenantId);

        return true;
    }
}