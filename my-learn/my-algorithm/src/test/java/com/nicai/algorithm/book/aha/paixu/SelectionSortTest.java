package com.nicai.algorithm.book.aha.paixu;

import com.nicai.util.ArrayUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-04-08
 */
public class SelectionSortTest {

    private static final int[] TO_BE_SORT_ARRAY = new int[] { 10, 3, 5, 7, 9, 12 };

    @Test
    public void sort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] sorted = selectionSort.sort(TO_BE_SORT_ARRAY);
        for (int i : TO_BE_SORT_ARRAY) {
            System.out.println("TO_BE_SORT_ARRAY= " + i);
        }
        Assert.assertTrue(ArrayUtil.isSorted(sorted));
    }

}
