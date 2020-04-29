package com.nicai.dao.impl;

import com.nicai.BaseTest;
import com.nicai.dao.MyTable0Dao;
import com.nicai.entity.MyTable0;
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
public class MyTable0DaoImplTest extends BaseTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private MyTable0Dao dao;

    @Test
    public void save() {
        String name = "nicai";
        Long id = dao.save(name);
        MyTable0 myTable0 = dao.getById(id);
        Assert.assertEquals(name, myTable0.getName());
        Assert.assertFalse(systemOutRule.getLog().contains("切换数据源=READONLY_DATASOURCE"));
    }

}