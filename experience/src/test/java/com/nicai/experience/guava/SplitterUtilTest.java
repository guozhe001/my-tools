package com.nicai.experience.guava;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhe
 * @date 2020-04-01
 */
@Slf4j
public class SplitterUtilTest {

    private static final String a = "111,232,222";

    /**
     * java.util.Collections$UnmodifiableRandomAccessList是不可变的列表，继承自
     * 父类java.util.Collections$UnmodifiableCollection的removeIf方法直接跑出UnsupportedOperationException异常
     */
    @org.junit.Test(expected = UnsupportedOperationException.class)
    public void guavaSplit() {
        listRemove(SplitterUtil.guavaSplit(a));
    }


    @org.junit.Test
    public void guavaSplit_CheckInstance() {
        List<String> list = SplitterUtil.guavaSplit(a);
        log.info("guavaSplit type is: {}", list.getClass().getName());
        Assert.assertEquals(list.getClass().getName(), "java.util.Collections$UnmodifiableRandomAccessList");
    }

    @org.junit.Test
    public void jdkSplit() {
        List<String> jdkSplit = SplitterUtil.jdkSplit(a);
        Assert.assertTrue(jdkSplit instanceof ArrayList);
        listRemove(jdkSplit);
        Assert.assertEquals(2, jdkSplit.size());
    }

    private void listRemove(List<String> list) {
        list.removeIf(str -> str.contains("3"));
    }
}