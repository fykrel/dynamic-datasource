package com.fangyk.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangyk
 * @date 2023年07月14日 18:58
 */
@Configuration
@ConfigurationProperties(prefix = "dynamic")
public class DynamicDatasourceProperties {

    /**
     * 租户隔离类型
     */
    private Type type = Type.ONE;

    /**
     * 租户字段名
     */
    private String tenantFieldName = "tenantId";

    /**
     * 隔离类型
     */
    public enum Type {
        /**
         * 单数据源 通过表中租户字段隔离
         */
        ONE,

        /**
         * 单数据源 通过表名隔离
         */
        TWO,

        /**
         * 单数据源 通过库名隔离
         */
        THREE,

        /**
         * 多数据源 数据库链接隔离
         */
        FOUR
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTenantFieldName() {
        return tenantFieldName;
    }

    public void setTenantFieldName(String tenantFieldName) {
        this.tenantFieldName = tenantFieldName;
    }
}