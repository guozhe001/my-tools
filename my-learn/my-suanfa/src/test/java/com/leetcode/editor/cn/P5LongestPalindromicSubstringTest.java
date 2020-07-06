package com.leetcode.editor.cn;

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

}