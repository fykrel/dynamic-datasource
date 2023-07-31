package com.fangyk.domain;

import java.io.Serializable;

/**
 * 数据源
 *
 * @author fangyk
 * @date 2023年07月28日 10:41
 */
public class TenantDataSource implements Serializable {
    /**
     * 租户ID
     */
    private Object tenantId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库驱动
     */
    private String driver;

    /**
     * 数据库配置
     */
    private String params;

    /**
     * 数据库地址
     */
    private String host;

    /**
     * 业务字段
     */
    private String biz;

    public Object getTenantId() {
        return tenantId;
    }

    public void setTenantId(Object tenantId) {
        this.tenantId = tenantId;
    }

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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBiz() {
        return biz;
    }

    public void setBiz(String biz) {
        this.biz = biz;
    }
}