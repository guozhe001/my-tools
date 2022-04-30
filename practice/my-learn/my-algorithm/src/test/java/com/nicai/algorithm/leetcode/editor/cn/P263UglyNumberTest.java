package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P263UglyNumberTest
 *
 * @author guozhe
 * @date 2020/09/27
 */
public class P263UglyNumberTest {

    private P263UglyNumber.Solution solution = new P263UglyNumber().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: 6
     * 输出: true
     * 解释: 6 = 2 × 3
     */
    @Test
    public void isUgly1() {
        Assert.assertTrue(solution.isUgly(6));
    }

    /**
     * 示例 2:
     * 输入: 8
     * 输出: true
     * 解释: 8 = 2 × 2 × ️2
     */
    @Test
    public void isUgly2() {
        Assert.assertTrue(solution.isUgly(8));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: 14
     * 输出: false
     * 解释: 14 不是丑数，因为它包含了另外一个质因数7。
     */
    @Test
    public void isUgly3() {
        Assert.assertFalse(solution.isUgly(14));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: 1
     * 输出: true
     */
    @Test
    public void isUgly4() {
        Assert.assertTrue(solution.isUgly(1));
    }

    /**
     * 示例 -8:
     * <p>
     * 输入: -8
     * 输出: false
     * 解释: 只有正整数才可以判断是否是丑数
     */
    @Test
    public void isUgly5() {
        Assert.assertFalse(solution.isUgly(-8));
    }

}