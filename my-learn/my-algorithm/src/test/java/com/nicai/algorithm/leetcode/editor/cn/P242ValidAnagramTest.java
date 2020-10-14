package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P242ValidAnagramTest
 *
 * @author guozhe
 * @date 2020/10/14
 */
public class P242ValidAnagramTest {

    private P242ValidAnagram.Solution solution = new P242ValidAnagram().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    @Test
    public void isAnagram() {
        Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    @Test
    public void isAnagram1() {
        Assert.assertFalse(solution.isAnagram("rat", "car"));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: s = null, t = null
     * 输出: false
     */
    @Test
    public void isAnagram2() {
        Assert.assertFalse(solution.isAnagram(null, null));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: s = "", t = ""
     * 输出: true
     */
    @Test
    public void isAnagram3() {
        Assert.assertTrue(solution.isAnagram("", ""));
    }
}