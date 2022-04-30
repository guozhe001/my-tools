package com.nicai.dao.impl;

import com.nicai.BaseTest;
import com.nicai.dao.MyTable1Dao;
import com.nicai.entity.MyTable1;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@ActiveProfiles("dev")
public class MyTable1DaoImplTest extends BaseTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private MyTable1Dao myTable1Dao;

    @Test
    public void save() {
        String name = "nicai";
        Long id = myTable1Dao.save(name);
        MyTable1 myTable1 = myTable1Dao.getById(id);
        Assert.assertEquals(name, myTable1.getName());
        Assert.assertTrue(systemOutRule.getLog().contains("切换数据源=READONLY_DATASOURCE"));
    }

}