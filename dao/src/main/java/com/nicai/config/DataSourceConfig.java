package com.nicai.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.collect.Maps;
import com.nicai.enums.DataSourceEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 数据源配置
 *
 * @author guozhe
 * @date 2020-02-27
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "readOnlyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.readOnly")
    public DataSource readOnlyDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = Maps.newHashMap();
        dsMap.put(DataSourceEnum.PRIMARY_DATASOURCE, dataSource());
        dsMap.put(DataSourceEnum.READONLY_DATASOURCE, readOnlyDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

}
