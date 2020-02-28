package com.nicai.config;

import com.nicai.enums.DataSourceEnum;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author guozhe
 * @date 2020-02-28
 */
@RunWith(JMockit.class)
public class DynamicDataSourceTest {

    @Tested
    private DynamicDataSource dynamicDataSource;

    @Test
    public void determineCurrentLookupKey_null() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dynamicDataSource = (DynamicDataSource) dataSourceConfig.dynamicDataSource();
        Assert.assertNull(dynamicDataSource.determineCurrentLookupKey());
    }

    @Test
    public void determineCurrentLookupKey_notNull() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dynamicDataSource = (DynamicDataSource) dataSourceConfig.dynamicDataSource();
        DataSourceContextHolder.setDataSource(DataSourceEnum.READONLY_DATASOURCE);
        Assert.assertNotNull(dynamicDataSource.determineCurrentLookupKey());
        DataSourceContextHolder.clearDataSource();
    }

}