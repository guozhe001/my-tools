package com.nicai.algorithm.book.algs4.practice.two;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class MergeTest {

    Sort<Integer> sort = new Merge<>();

    @Test
    public void sort() throws Exception {
        Integer[] integers = new Integer[]{1, 2, 3, 2, 3, 4};
        Whitebox.invokeMethod(sort, "merge", integers, 0, 2, integers.length - 1);
        sort.show(integers);
        Assert.assertTrue(sort.isSorted(integers));
    }
}