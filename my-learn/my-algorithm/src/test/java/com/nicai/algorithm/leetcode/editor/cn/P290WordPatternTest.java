package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P290WordPatternTest {

    private final P290WordPattern.Solution solution = new P290WordPattern().new Solution();

    /**
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     */
    @Test
    public void wordPattern() {
        invoke("abba", "dog cat cat dog", true);
    }

    /**
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     */
    @Test
    public void wordPattern2() {
        invoke("abba", "dog cat cat fish", false);
    }

    /**
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     */
    @Test
    public void wordPattern3() {
        invoke("aaaa", "dog cat cat dog", false);
    }

    /**
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     */
    @Test
    public void wordPattern4() {
        invoke("abba", "dog dog dog dog", false);
    }

    /**
     * 示例 5:
     * 输入: pattern = "abc", str = "dog cat dog"
     * 输出: false
     */
    @Test
    public void wordPattern5() {
        invoke("abc", "dog cat dog", false);
    }


    private void invoke(String pattern, String str, boolean expect) {
        Assert.assertEquals(expect, solution.wordPattern(pattern, str));
    }

}