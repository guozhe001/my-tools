package com.nicai.experience.guava;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckPhoneNumberTest {

    /**
     * 返回手机号码
     */
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    @Test
    public void test() {
        List<String> collect = IntStream.range(0, 100000).parallel()
                .mapToObj(i -> getTel()).collect(Collectors.toList());
        Stopwatch stopwatch = Stopwatch.createStarted();
        collect.forEach(phoneNumber -> {
            if (CheckPhoneNumber.check(phoneNumber)) {
                System.out.println(phoneNumber);
            }
        });
        System.out.println("spend " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " MILLISECONDS");
    }

    @Test
    public void check() {
        Assert.assertTrue(CheckPhoneNumber.check("12345678901"));
    }

    @Test
    public void check1() {
        Assert.assertFalse(CheckPhoneNumber.check("18651866593"));
    }

}
