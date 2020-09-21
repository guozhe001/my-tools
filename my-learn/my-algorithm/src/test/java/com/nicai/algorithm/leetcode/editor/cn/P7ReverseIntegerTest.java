package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P7ReverseIntegerTest
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class P7ReverseIntegerTest {
    P7ReverseInteger.Solution solution = new P7ReverseInteger().new Solution();

    /**
     * 示例 1:
     * 输入: 123
     * 输出: 321
     */
    @Test
    public void reverse() {
        int reverse = solution.reverse(123);
        Assert.assertEquals(321, reverse);
    }

    /**
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     */
    @Test
    public void reverse2() {
        int reverse = solution.reverse(-123);
        Assert.assertEquals(-321, reverse);
    }

    /**
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     */
    @Test
    public void reverse3() {
        int reverse = solution.reverse(120);
        Assert.assertEquals(21, reverse);
    }

    /**
     * 示例 4:
     * <p>
     * 输入: 负的2的31次幂
     * 输出: 0
     */
    @Test
    public void reverse4() {
        int reverse = solution.reverse(Math.negateExact(Integer.MAX_VALUE));
        Assert.assertEquals(0, reverse);
    }
}