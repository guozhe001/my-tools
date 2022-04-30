package com.nicai.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.AbstractDataSourceInitializer;
import org.springframework.boot.jdbc.DataSourceInitializationMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

/**
 * @author guozhe
 * @date 2020-04-29
 */
@Configuration
@Profile("dev")
public class MyDataSourceInitializer extends AbstractDataSourceInitializer {

    protected MyDataSourceInitializer(@Qualifier("dataSource") DataSource dataSource, ResourceLoader resourceLoader) {
        super(dataSource, resourceLoader);
    }

    @Override
    protected DataSourceInitializationMode getMode() {
        return DataSourceInitializationMode.ALWAYS;
    }

    @Override
    protected String getSchemaLocation() {
        return "classpath:db/schema0.sql";
    }
}
