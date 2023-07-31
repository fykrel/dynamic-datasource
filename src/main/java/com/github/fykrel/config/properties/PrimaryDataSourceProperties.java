package com.github.fykrel.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;

/**
 * 默认数据源配置
 *
 * @author fangyk
 * @date 2023年07月31日 14:46
 */
@ConfigurationProperties(prefix = "primary-data-source")
public class PrimaryDataSourceProperties {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库链接
     */
    private String url;

    /**
     * 驱动
     */
    private String driverClassName;

    /**
     * 数据源类型
     */
    private Class<? extends DataSource> type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Class<? extends DataSource> getType() {
        return type;
    }

    public void setType(Class<? extends DataSource> type) {
        this.type = type;
    }
}