package com.nicai.experience.guava;

import org.junit.Assert;

import java.util.List;

/**
 * @author guozhe
 * @date 2020-04-01
 */
public class GuavaSplitterTest {

    private static final String a = "111,232,222";

    @org.junit.Test(expected = UnsupportedOperationException.class)
    public void guavaSplit() {
        listRemove(GuavaSplitter.guavaSplit(a));
    }

    @org.junit.Test
    public void jdkSplit() {
        List<String> jdkSplit = GuavaSplitter.jdkSplit(a);
        listRemove(jdkSplit);
        Assert.assertEquals(2, jdkSplit.size());
    }

    private void listRemove(List<String> list) {
        list.removeIf(str -> str.contains("3"));
    }
}