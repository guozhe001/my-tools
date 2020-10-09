package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P220ContainsDuplicateIiiTest
 *
 * @author guozhe
 * @date 2020/10/09
 */
public class P220ContainsDuplicateIiiTest {

    private P220ContainsDuplicateIii.Solution solution = new P220ContainsDuplicateIii().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     */
    @Test
    public void containsNearbyAlmostDuplicate1() {
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     */
    @Test
    public void containsNearbyAlmostDuplicate2() {
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     */
    @Test
    public void containsNearbyAlmostDuplicate3() {
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: nums = [-2147483648,2147483647], k = 1, t = 1
     * 输出: false
     */
    @Test
    public void containsNearbyAlmostDuplicate4() {
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
    }
}