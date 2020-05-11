package com.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020-05-11
 */
@Slf4j
public class P1TwoSumTest {

    private static final P1TwoSum.Solution SOLUTION = new P1TwoSum().new Solution();

    @Test
    public void main() {
        processAndCheckResult(new int[]{2, 7, 12, 45}, 9, new int[]{0, 1});
    }

    @Test
    public void main0() {
        processAndCheckResult(new int[]{2, 11, 12, 45, 7}, 9, new int[]{0, 4});
    }

    @Test
    public void main1() {
        processAndCheckResult(new int[]{2, 11, 7, 45, 7}, 9, new int[]{0, 2});
    }

    @Test
    public void main2() {
        processAndCheckResult(new int[]{11, 17, 2, 45, 7}, 9, new int[]{2, 4});
    }

    @Test
    public void main3() {
        processAndCheckResult(new int[]{11, 17, 2, 2, 45, 7}, 9, new int[]{2, 5});
    }

    private static void processAndCheckResult(int[] nums, int target, int[] expect) {
        int[] result = SOLUTION.twoSum(nums, target);
        Assert.assertEquals(expect[0], result[0]);
        Assert.assertEquals(expect[1], result[1]);
    }

}