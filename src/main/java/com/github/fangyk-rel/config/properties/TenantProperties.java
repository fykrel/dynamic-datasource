package com.fangyk.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 租户配置
 *
 * @author fangyk
 * @date 2023年07月14日 18:58
 */
@ConfigurationProperties(prefix = "tenant")
public class TenantProperties {
    /**
     * 租户字段名
     */
    private String tenantFieldName;

    /**
     * 租户数据库分隔符
     */
    private String tenantSeparator;

    public String getTenantSeparator() {
        return tenantSeparator;
    }

    public void setTenantSeparator(String tenantSeparator) {
        this.tenantSeparator = tenantSeparator;
    }

    public String getTenantFieldName() {
        return tenantFieldName;
    }

    public void setTenantFieldName(String tenantFieldName) {
        this.tenantFieldName = tenantFieldName;
    }
}