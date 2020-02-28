package com.nicai.config;


import com.nicai.enums.DataSourceEnum;

/**
 * 数据库上下文管理者
 *
 * @author guozhe
 */
public class DataSourceContextHolder {

    /**
     * 当前线程中的数据源
     */
    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dbType 指定的数据源
     */
    public static void setDataSource(DataSourceEnum dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    /**
     * 获取数据源
     *
     * @return 当前线程的数据源
     */
    public static DataSourceEnum getDataSource() {
        return (CONTEXT_HOLDER.get());
    }

    /**
     * 清楚数据源
     */
    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }
}
