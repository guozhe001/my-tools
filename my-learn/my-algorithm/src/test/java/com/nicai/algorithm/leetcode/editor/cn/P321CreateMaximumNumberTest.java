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

    private void invokeMaxNumber(int[] m, int[] n, int k, int[] expect) {
        int[] ints = solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf(ints[i] + " ");
        }
        Assert.assertArrayEquals(new int[]{9, 8, 6, 5, 3}, ints);
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
    public void toArray() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "toArray", ImmutableList.of(
                getMaxNumber(5, 9, false),
                getMaxNumber(0, 3, false),
                getMaxNumber(4, 5, true)));
        Assert.assertArrayEquals(new int[]{3, 5, 9}, nums);
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
    public void toMaxNumberArray() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "toMaxNumberArray", ImmutableList.of(
                getMaxNumber(5, 8, false),
                getMaxNumber(0, 1, false),
                getMaxNumber(4, 3, false),
                getMaxNumber(1, 7, true),
                getMaxNumber(0, 8, true),
                getMaxNumber(2, 1, true)
        ));
        Assert.assertArrayEquals(new int[]{8, 7, 1, 3, 8, 1}, nums);
    }

    @Test
    public void merge() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{1, 3, 8}, new int[]{8, 7, 1}, 6);
        Assert.assertArrayEquals(new int[]{8, 7, 1, 3, 8, 1}, nums);
    }

    @Test
    public void merge1() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{1, 3, 8}, new int[]{8, 7, 1}, 5);
        Assert.assertArrayEquals(new int[]{8, 7, 1, 3, 8}, nums);
    }

    @Test
    public void merge2() throws Exception {
        int[] nums = Whitebox.invokeMethod(solution, "merge", new int[]{1, 3, 8}, new int[]{8, 7, 1}, 3);
        Assert.assertArrayEquals(new int[]{8, 8, 7}, nums);
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

    private P321CreateMaximumNumber.Solution.UsedNumber getMaxNumber(int index, int value, boolean fromNums1) {
        P321CreateMaximumNumber.Solution.UsedNumber usedNumber = solution.new UsedNumber();
        usedNumber.setIndex(index);
        usedNumber.setValue(value);
        usedNumber.setFromNums1(fromNums1);
        return usedNumber;
    }
}