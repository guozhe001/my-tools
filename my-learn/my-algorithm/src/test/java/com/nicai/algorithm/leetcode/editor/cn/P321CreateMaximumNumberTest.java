package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

@Slf4j
public class P321CreateMaximumNumberTest {

    private final P321CreateMaximumNumber.Solution solution = new P321CreateMaximumNumber().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入:
     * nums1 = [3, 4, 6, 5]
     * nums2 = [9, 1, 2, 5, 8, 3]
     * k = 5
     * 输出:
     * [9, 8, 6, 5, 3]
     */
    @Test
    public void maxNumber() {
        invokeMaxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5, new int[]{9, 8, 6, 5, 3});
    }

    /**
     * 示例 2:
     * <p>
     * 输入:
     * nums1 = [6, 7]
     * nums2 = [6, 0, 4]
     * k = 5
     * 输出:
     * [6, 7, 6, 0, 4]
     */
    @Test
    public void maxNumber1() {
        invokeMaxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5, new int[]{6, 7, 6, 0, 4});
    }

    /**
     * 示例 3:
     * <p>
     * 输入:
     * nums1 = [3, 9]
     * nums2 = [8, 9]
     * k = 3
     * 输出:
     * [9, 8, 9]
     */
    @Test
    public void maxNumber2() {
        invokeMaxNumber(new int[]{3, 9}, new int[]{8, 9}, 3, new int[]{9, 8, 9});
    }

    /**
     * [5,5,1]
     * [4,0,1]
     * 3
     * 期望结果:[5,5,4]
     */
    @Test
    public void maxNumber3() {
        invokeMaxNumber(new int[]{5, 5, 1}, new int[]{4, 0, 1}, 3, new int[]{5, 5, 4});
    }

    private void invokeMaxNumber(int[] m, int[] n, int k, int[] expect) {
        int[] ints = solution.maxNumber(m, n, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf(ints[i] + " ");
        }
        Assert.assertArrayEquals(expect, ints);
    }

    @Test
    public void findMaxNumber() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "findMaxNumber", new int[]{1, 3, 8, 7, 9, 3}, 3);
        Assert.assertArrayEquals(new int[]{8, 9, 3}, nums);
    }

    @Test
    public void findMaxNumber2() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "findMaxNumber", new int[]{1, 3, 8, 7, 9, 3}, 4);
        Assert.assertArrayEquals(new int[]{8, 7, 9, 3}, nums);
    }

    @Test
    public void findMaxNumber3() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "findMaxNumber", new int[]{1, 3, 8, 7, 9, 3}, 5);
        Assert.assertArrayEquals(new int[]{3, 8, 7, 9, 3}, nums);
    }

    @Test
    public void findMaxNumber4() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "findMaxNumber", new int[]{5, 5, 1}, 3);
        Assert.assertArrayEquals(new int[]{5, 5, 1}, nums);
    }


    @Test
    public void dp() throws Exception {
        int[][] nums = Whitebox.invokeMethod(solution, "dp", new int[]{1, 3, 8, 7, 9, 3}, 5);
        for (int i = 0; i < nums.length; i++) {
            log.info("i={}", i);
            int[] num = nums[i];
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]);
            }
            System.out.println();
        }
    }

    @Test
    public void merge() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{8}, new int[]{8, 7}, 3);
        Assert.assertArrayEquals(new int[]{8, 8, 7}, nums);
    }

    @Test
    public void merge1() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{1, 3, 8}, new int[]{8, 7, 1}, 6);
        Assert.assertArrayEquals(new int[]{8, 7, 1, 3, 8, 1}, nums);
    }

    @Test
    public void merge2() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{3, 8}, new int[]{2, 7}, 4);
        Assert.assertArrayEquals(new int[]{3, 8, 2, 7}, nums);
    }

    @Test
    public void getMax() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "getMax", ImmutableList.of(
                new int[]{1, 0, 0},
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{2, 0, 0},
                new int[]{2, 0, 1}
        ));
        Assert.assertArrayEquals(new int[]{2, 0, 1}, nums);
    }

}