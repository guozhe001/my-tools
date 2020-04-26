package com.aha.suanfa.paixu;


/**
 * @author guozhe
 * @date 2019-04-08
 */
public class SelectionSortTest {

    private static final int[] TO_BE_SORT_ARRAY = new int[]{10, 3, 5, 7, 9, 12};

    @org.junit.Test
    public void sort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] sorted = selectionSort.sort(TO_BE_SORT_ARRAY);
        for (int i : TO_BE_SORT_ARRAY) {
            System.out.println("TO_BE_SORT_ARRAY= " + i);
        }
        for (int i : sorted) {
            System.out.println("sorted= " + i);
        }
    }

    @org.junit.Test
    public void sort1() {
    }
}
