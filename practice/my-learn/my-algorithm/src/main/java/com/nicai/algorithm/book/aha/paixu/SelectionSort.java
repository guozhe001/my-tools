package com.nicai.algorithm.book.aha.paixu;

/**
 * @author guozhe
 * @date 2019-04-08
 */
public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] a) {
        int[] sorted = new int[a.length];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex1 = getMinIndex(a);
            sorted[i] = a[minIndex1];
            a = pop(minIndex1, a);
        }
        return sorted;
    }

    /**
     * 把数组a的在索引为index位置的数据弹出，后面的索引往前移动
     *
     * @param index 需要弹出的索引
     * @param a     需要处理的数组
     * @return 返回弹出后的新的数组
     */
    private int[] pop(int index, int[] a) {
        int[] result = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
            if (i < index) {
                result[i] = a[i];
            } else {
                result[i] = a[i + 1];
            }
        }
        return result;
    }

    /**
     * 获取数组a的数值最小的值所在的索引
     *
     * @param a 数组
     * @return 数值最小的值所在的索引
     */
    private int getMinIndex(int[] a) {
        int minValue = a[0];
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Override
    public int[] sort1(int[] a) {
        return new int[0];
    }

}
