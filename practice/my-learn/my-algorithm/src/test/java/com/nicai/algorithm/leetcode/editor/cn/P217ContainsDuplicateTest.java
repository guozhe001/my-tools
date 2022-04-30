package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P217ContainsDuplicateTest
 *
 * @author guozhe
 * @date 2020/09/30
 */
public class P217ContainsDuplicateTest {

    private P217ContainsDuplicate.Solution solution = new P217ContainsDuplicate().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: true
     */
    @Test
    public void containsDuplicate() {
        Assert.assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: false
     */
    @Test
    public void containsDuplicate1() {
        Assert.assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    @Test
    public void containsDuplicate2() {
        Assert.assertTrue(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

}