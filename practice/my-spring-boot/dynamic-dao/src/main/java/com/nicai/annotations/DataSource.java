package com.nicai.annotations;

import com.nicai.enums.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 多数据源配置注解，如果不使用默认的主数据库，则指定需要链接的数据库
 *
 * @author guozhe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DataSource {

    /**
     * 指定的数据源
     *
     * @return 数据源枚举，默认主库
     */
    DataSourceEnum value() default DataSourceEnum.PRIMARY_DATASOURCE;

}
