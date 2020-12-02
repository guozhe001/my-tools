package com.nicai.algorithm.book.algs4.practice.two;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class SortTest {

    private static final Integer[] INTEGERS = {3, 2, 1};

    private static final Sort<Integer> DEFAULT = comparableArray -> {
        assert false;
    };

    private static final List<Sort<Integer>> SORT_IMPL = ImmutableList.of(new Selection<>(), new Insertion<>(), new Merge<>());

    @Test
    public void testSort() {
        SORT_IMPL.forEach(this::invokeSortAndAssert);
    }

    public void invokeSortAndAssert(Sort<Integer> sort) {
        String name = sort.getClass().getSimpleName();
        log.info("sort name ={} start", name);
        Integer[] integers = Arrays.copyOf(INTEGERS, INTEGERS.length);
        sort.show(integers);
        sort.sort(integers);
        sort.show(integers);
        Assert.assertTrue(sort.isSorted(integers));
        log.info("sort name ={} end", name);
    }

    @Test
    public void less() {
        Assert.assertTrue(DEFAULT.less(1, 2));
    }

    @Test
    public void exch() {
        Integer[] integers = Arrays.copyOf(INTEGERS, INTEGERS.length);
        DEFAULT.show(integers);
        DEFAULT.exch(integers, 0, 2);
        Assert.assertEquals(Integer.valueOf(1), integers[0]);
        Assert.assertEquals(Integer.valueOf(2), integers[1]);
        Assert.assertEquals(Integer.valueOf(3), integers[2]);
        DEFAULT.show(integers);
        Assert.assertTrue(DEFAULT.isSorted(integers));
    }

}