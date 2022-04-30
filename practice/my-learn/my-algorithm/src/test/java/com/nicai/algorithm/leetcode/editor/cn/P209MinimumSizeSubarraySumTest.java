package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * P209MinimumSizeSubarraySumTest
 *
 * @author guozhe
 * @date 2020/10/16
 */
public class P209MinimumSizeSubarraySumTest {

    private P209MinimumSizeSubarraySum.Solution solution = new P209MinimumSizeSubarraySum().new Solution();

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void minSubArrayLen1() {
        Assert.assertEquals(1, solution.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    public void minSubArrayLen2() {
        Assert.assertEquals(8, solution.minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
    }

    @Test
    public void sub() throws Exception {
        Assert.assertArrayEquals(new int[]{2, 3, 1}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 3, 1, 2, 4, 3}, 0, 3));
    }

    @Test
    public void sub0() throws Exception {
        Assert.assertArrayEquals(new int[]{2, 4, 3}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 3, 1, 2, 4, 3}, 3, 3));
    }

    @Test
    public void sub1() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 3, 1}, 0, 1));
    }

    @Test
    public void sub2() throws Exception {
        Assert.assertArrayEquals(new int[]{3, 1}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 3, 1}, 1, 2));
    }

    @Test
    public void sub3() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 4, 3}, 0, 1));
    }

    @Test
    public void sub4() throws Exception {
        Assert.assertArrayEquals(new int[]{4, 3}, Whitebox.invokeMethod(solution, "sub", new int[]{2, 4, 3}, 1, 2));
    }

    @Test
    public void sumBigThanTarget() throws Exception {
        Assert.assertTrue(Whitebox.invokeMethod(solution, "sumBigThanTarget", new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

    @Test
    public void sumBigThanTarget1() throws Exception {
        Assert.assertFalse(Whitebox.invokeMethod(solution, "sumBigThanTarget", new int[]{2, 3, 1}, 7));
    }

    @Test
    public void sumBigThanTarget2() throws Exception {
        Assert.assertTrue(Whitebox.invokeMethod(solution, "sumBigThanTarget", new int[]{2, 4, 3}, 7));
    }

    @Test
    public void sum3() throws Exception {
        Assert.assertTrue(Whitebox.invokeMethod(solution, "sumBigThanTarget", new int[]{3, 4}, 7));
    }
}