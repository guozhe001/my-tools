package com.nicai.aspect;

import cn.hutool.core.util.ObjectUtil;
import com.nicai.annotations.DataSource;
import com.nicai.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 动态数据库切面
 *
 * @author guozhe
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    /**
     * 拦截点为dao包下的所有的类的所有方法
     */
    @Pointcut("execution(* com.nicai.dao..*(..))")
    private void advice() {
    }

    /**
     * 根据类上的DataSource设置动态修改当前线程的数据源
     *
     * @param point 连接点
     */
    @Before("advice()")
    public void before(JoinPoint point) {
        //当前访问的class
        Class<?> clazz = point.getTarget().getClass();
        DataSource dataSource = clazz.getAnnotation(DataSource.class);
        // 如果有指定数据源的注解，则使用指定的数据源，否则不指定使用默认数据源
        if (ObjectUtil.isNotNull(dataSource)) {
            log.info("Class={}, method={}, 切换数据源={}", clazz.getName(), point.getSignature().getName(), dataSource.value());
            // 切换数据源
            DataSourceContextHolder.setDataSource(dataSource.value());
        }
    }

    /**
     * 清空当前线程的数据源，下次如果指定在设置，不指定使用默认值
     */
    @After("advice()")
    public void after() {
        DataSourceContextHolder.clearDataSource();
    }

}
