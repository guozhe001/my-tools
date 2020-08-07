package com.nicai.algorithm.aha.paixu;

/**
 * 桶排序
 *
 * @author guozhe
 * @date 2018/11/13
 */
public class TongPaiXu extends Print implements Sort {
    public TongPaiXu() {
        System.out.println("================================================桶排序================================================");
    }

    @Override
    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                System.out.print(i + "  ");
            }
        }
        System.out.println("");
        System.out.println("================================================");
    }

    @Override
    public void printDesc(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a[i]; j++) {
                System.out.print(i + "  ");
            }
        }
        System.out.println("");
        System.out.println("================================================");
    }

    /**
     * 第一次
     *
     * @param a
     * @return
     */
    @Override
    public int[] sort(int[] a) {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 11; i++) {
            for (int j : a) {
                if (j == i) {
                    result[i] = result[i] + 1;
                }
            }
        }
        return result;
    }

    /**
     * 第二次
     *
     * @param
     * @return
     */
    @Override
    public int[] sort1(int[] a) {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int j : a) {
            result[j] = result[j] + 1;
        }
        return result;
    }

    /**
     * 第三次
     *
     * @param
     * @return
     */
    public static int[] sort2(int[] a) {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int j : a) {
            result[j]++;
        }
        return result;
    }

}
