package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P859BuddyStringsTest {
    private final P859BuddyStrings.Solution solution = new P859BuddyStrings().new Solution();

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入： A = "ab", B = "ba"
     * 输出： true
     * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
     */
    @Test
    public void buddyStrings() {
        Assert.assertTrue(solution.buddyStrings("ab", "ba"));
    }


    /**
     * 示例 2：
     * <p>
     * <p>
     * 输入： A = "ab", B = "ab"
     * 输出： false
     * 解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
     */
    @Test
    public void buddyStrings2() {
        Assert.assertFalse(solution.buddyStrings("ab", "ab"));
    }

    /**
     * 示例 3:
     * <p>
     * <p>
     * 输入： A = "aa", B = "aa"
     * 输出： true
     * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。
     */
    @Test
    public void buddyStrings3() {
        Assert.assertTrue(solution.buddyStrings("aa", "aa"));
    }

    /**
     * 示例 4：
     * <p>
     * <p>
     * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
     * 输出： true
     */
    @Test
    public void buddyStrings4() {
        Assert.assertTrue(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    /**
     * 示例 5：
     * <p>
     * <p>
     * 输入： A = "", B = "aa"
     * 输出： false
     */
    @Test
    public void buddyStrings5() {
        Assert.assertFalse(solution.buddyStrings("", "aa"));
    }

    /**
     * 解答失败:
     * 测试用例:"abcd" ,"badc"
     * 测试结果:true
     * 期望结果:false
     */
    @Test
    public void buddyStrings6() {
        Assert.assertFalse(solution.buddyStrings("abcd", "badc"));
    }

    /**
     * 解答失败:
     * 测试用例:"abcaa", "abcbb"
     * 测试结果:true
     * 期望结果:false
     */
    @Test
    public void buddyStrings7() {
        Assert.assertFalse(solution.buddyStrings("abcaa", "abcbb"));
    }
}