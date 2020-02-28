package com.nicai.dao;

import com.nicai.BaseMysqlTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guozhe
 * @date 2020-02-28
 */
@Slf4j
public class HelloDAOTest extends BaseMysqlTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private HelloDao helloDao;

    @Test
    public void test() {
        systemOutRule.clearLog();
        helloDao.getById(1L);
        Assert.assertTrue(systemOutRule.getLog().contains("切换数据源=READONLY_DATASOURCE"));
    }

}