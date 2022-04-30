package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P9PalindromeNumberTest {

    private final P9PalindromeNumber.Solution solution = new P9PalindromeNumber().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     */
    @Test
    public void isPalindrome() {
        Assert.assertTrue(solution.isPalindrome(121));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     */
    @Test
    public void isPalindrome1() {
        Assert.assertFalse(solution.isPalindrome(-121));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     */
    @Test
    public void isPalindrome2() {
        Assert.assertFalse(solution.isPalindrome(10));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: 0
     * 输出: true
     */
    @Test
    public void isPalindrome3() {
        Assert.assertTrue(solution.isPalindrome(0));
    }

    /**
     * 示例 5:
     * <p>
     * 输入: 11
     * 输出: true
     */
    @Test
    public void isPalindrome4() {
        Assert.assertTrue(solution.isPalindrome(11));
    }

    /**
     * 示例 6:
     * <p>
     * 输入: 313
     * 输出: true
     */
    @Test
    public void isPalindrome5() {
        Assert.assertTrue(solution.isPalindrome(313));
    }

    /**
     * 示例 7:
     * <p>
     * 输入: 1000021
     * 输出: false
     */
    @Test
    public void isPalindrome6() {
        Assert.assertFalse(solution.isPalindrome(1000021));
    }

    /**
     * 示例 8:
     * <p>
     * 输入: 1000110001
     * 输出: true
     */
    @Test
    public void isPalindrome7() {
        Assert.assertTrue(solution.isPalindrome(1000110001));
    }

    @Test
    public void testLog10() {
        Assert.assertEquals(2, (int) Math.log10(100));
    }

    @Test
    public void testLog101() {
        Assert.assertEquals(2, (int) Math.log10(101));
    }

    @Test
    public void testLog102() {
        Assert.assertEquals(2, (int) Math.log10(999));
    }

    @Test
    public void testLog103() {
        Assert.assertEquals(3, (int) Math.log10(1001));
    }
}