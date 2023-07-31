package io.github.fykrel.support;

/**
 * 租户ThreadLocal
 *
 * @author fangyk
 * @date 2023年07月27日 15:10
 */
public class TenantThreadLocalHolder {
    private static final ThreadLocal<Object> TENANT_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTenantId(Object tenantId) {
        TENANT_THREAD_LOCAL.set(tenantId);
    }

    public static Object getTenantId() {
        return TENANT_THREAD_LOCAL.get();
    }
}