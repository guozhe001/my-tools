package com.aha.suanfa.paixu;

/**
 * 冒泡排序
 *
 * @author guozhe
 * @date 2018/11/13
 */
public class MaoPao extends Print implements Sort {

    public MaoPao() {
        System.out.println("================================================冒泡排序================================================");
    }

    @Override
    public int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                int before = a[i];
                int after = a[i + 1];
                if (before < after) {
                    a[i] = after;
                    a[i + 1] = before;
                }
            }
        }
        return a;
    }

    @Override
    public int[] sort1(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        for (int j = 0; j < a.length; j++) {
            // 第一次循环已经把最小值排到了最后面，所以第二次循环没有必要比较最后一个数字了，以此类推
            for (int i = 0; i < a.length - j - 1; i++) {
                int before = a[i];
                int after = a[i + 1];
                if (before < after) {
                    a[i] = after;
                    a[i + 1] = before;
                }
            }
        }
        return a;
    }

    public int[] sort2(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        // 冒泡的次数只需要n-1次即可，因为最后一个数只剩下自己没有比较再比较
        for (int j = 0; j < a.length - 1; j++) {
            // 第一次循环已经把最小值排到了最后面，所以第二次循环没有必要比较最后一个数字了，以此类推
            for (int i = 0; i < a.length - j - 1; i++) {
                int before = a[i];
                int after = a[i + 1];
                if (before < after) {
                    a[i] = after;
                    a[i + 1] = before;
                }
            }
        }
        return a;
    }

}
