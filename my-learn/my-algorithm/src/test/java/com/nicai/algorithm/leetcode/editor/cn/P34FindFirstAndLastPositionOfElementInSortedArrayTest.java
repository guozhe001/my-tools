package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P34FindFirstAndLastPositionOfElementInSortedArrayTest {

    private final P34FindFirstAndLastPositionOfElementInSortedArray.Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */
    @Test
    public void searchRange() {
        int[] ints = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assert.assertArrayEquals(new int[]{3, 4}, ints);
    }

    /**
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     */
    @Test
    public void searchRange2() {
        int[] ints = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assert.assertArrayEquals(new int[]{-1, -1}, ints);
    }

    /**
     * 示例 3：
     * <p>
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    @Test
    public void searchRange3() {
        int[] ints = solution.searchRange(new int[]{}, 0);
        Assert.assertArrayEquals(new int[]{-1, -1}, ints);
    }

    /**
     * 示例 4：
     * <p>
     * <p>
     * 输入：nums = [1], target = 1
     * 输出：[0,0]
     */
    @Test
    public void searchRange4() {
        int[] ints = solution.searchRange(new int[]{1}, 1);
        Assert.assertArrayEquals(new int[]{0, 0}, ints);
    }

    /**
     * 示例 5：
     * <p>
     * <p>
     * 输入：nums = [1, 4], target = 4
     * 输出：[1,1]
     */
    @Test
    public void searchRange5() {
        int[] ints = solution.searchRange(new int[]{1, 4}, 4);
        Assert.assertArrayEquals(new int[]{1, 1}, ints);
    }

    /**
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：-1
     */
    @Test
    public void search() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int result = solution.search(nums, 6, 0, nums.length - 1);
        Assert.assertEquals(-1, result);
    }

    /**
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [1, 4], target = 4
     * 输出：1
     */
    @Test
    public void search2() {
        int[] nums = {1, 4};
        int result = solution.search(nums, 4, 0, nums.length - 1);
        Assert.assertEquals(1, result);
    }

    /**
     * 示例 3：
     * <p>
     * <p>
     * 输入：nums = [1,2,3], target = 1
     * 输出：0
     */
    @Test
    public void search3() {
        int[] nums = {1, 2, 3};
        int result = solution.search(nums, 1, 0, nums.length - 1);
        Assert.assertEquals(0, result);
    }
}