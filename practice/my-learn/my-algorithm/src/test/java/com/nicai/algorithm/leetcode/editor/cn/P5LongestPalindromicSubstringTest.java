package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020/7/6
 */
public class P5LongestPalindromicSubstringTest {

    P5LongestPalindromicSubstring.Solution solution = new P5LongestPalindromicSubstring().new Solution();

    /**
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     */
    @Test
    public void testCase1() {
        String result = solution.longestPalindrome("babad");
        Assert.assertEquals("bab", result);
    }

    /**
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
    @Test
    public void testCase2() {
        String result = solution.longestPalindrome("cbbd");
        Assert.assertEquals("bb", result);
    }

    /**
     * 输入 null
     */
    @Test
    public void testCaseNull() {
        Assert.assertNull(solution.longestPalindrome(null));
    }

    /**
     * 输入 ""
     */
    @Test
    public void testCaseBlank() {
        Assert.assertEquals("", solution.longestPalindrome(""));
    }

    /**
     * 输入 a
     */
    @Test
    public void testCaseOneChar() {
        Assert.assertEquals("a", solution.longestPalindrome("a"));
    }

    /**
     * 输入 ac
     */
    @Test
    public void testCaseTwoChar() {
        Assert.assertEquals("a", solution.longestPalindrome("ac"));
    }

    /**
     * 输入 aa
     */
    @Test
    public void testCaseTwoSameChar() {
        Assert.assertEquals("aa", solution.longestPalindrome("aa"));
    }

    /**
     * 输入 aaa
     */
    @Test
    public void testCaseThreeSameChar() {
        Assert.assertEquals("aaa", solution.longestPalindrome("aaa"));
    }


    /**
     * 输入 aacabdkacaa
     */
    @Test
    public void test() {
        Assert.assertEquals("aca", solution.longestPalindrome("aacabdkacaa"));
    }


    @Test
    public void testStringValueOf() {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        String s = String.valueOf(chars, 0, 3);
        Assert.assertEquals("abc", s);

    }
}