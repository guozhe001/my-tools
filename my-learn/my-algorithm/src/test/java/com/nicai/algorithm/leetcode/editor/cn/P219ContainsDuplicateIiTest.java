package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P219ContainsDuplicateIiTest
 *
 * @author guozhe
 * @date 2020/09/30
 */
public class P219ContainsDuplicateIiTest {

    private P219ContainsDuplicateIi.Solution solution = new P219ContainsDuplicateIi().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     */
    @Test
    public void containsNearbyDuplicate() {
        Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     */
    @Test
    public void containsNearbyDuplicate1() {
        Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    @Test
    public void containsNearbyDuplicate2() {
        Assert.assertFalse(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}