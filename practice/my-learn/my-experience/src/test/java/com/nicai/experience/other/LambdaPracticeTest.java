package com.nicai.experience.other;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author guozhe
 * @date 2020/6/12
 */
public class LambdaPracticeTest {

    private static final List<String> HAVE_DATA = Lists.newArrayList("test1", "123", "test2");

    private static final List<String> DO_NOT_HAVE_DATA = Lists.newArrayList("tes1t1", "123test");

    private static final String PREFIX = "test";

    @Test
    public void findOrElseGetWrongWay() {
        String first = LambdaPractice.findOrElseGetWrongWay(HAVE_DATA, PREFIX);
        Assert.assertEquals("test1", first);
    }

    @Test(expected = NullPointerException.class)
    public void findOrElseGetWrongWay1() {
        LambdaPractice.findOrElseGetWrongWay(DO_NOT_HAVE_DATA, PREFIX);
    }

    @Test
    public void findOrElseGetRightWay1() {
        String orElseGetRightWay = LambdaPractice.findOrElseGetRightWay(HAVE_DATA, PREFIX);
        Assert.assertEquals("test1", orElseGetRightWay);
    }

    @Test
    public void findOrElseGetRightWay() {
        String orElseGetRightWay = LambdaPractice.findOrElseGetRightWay(DO_NOT_HAVE_DATA, PREFIX);
        Assert.assertNull(orElseGetRightWay);
    }


}