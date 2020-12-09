package com.nicai.algorithm.book.algs4.practice.two;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickTest {

    private final Sort<Integer> quick = new Quick<>();

    @Test
    public void sort() {
        Integer[] integers = Arrays.copyOf(SortTest.INTEGERS, SortTest.INTEGERS.length);
        quick.sort(integers);
        quick.show(integers);
        Assert.assertEquals(SortTest.INTEGERS.length, integers.length);
        Assert.assertTrue(quick.isSorted(integers));
    }
}