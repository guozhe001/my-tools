package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 * P139WordBreakTest
 *
 * @author guozhe
 * @date 2020/09/30
 */
public class P139WordBreakTest {

    private P139WordBreak.Solution solution = new P139WordBreak().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     */
    @Test
    public void wordBreak() {
        Assert.assertTrue(solution.wordBreak("leetcode", Lists.newArrayList("leet", "code")));
    }

    /**
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     * 注意你可以重复使用字典中的单词。
     */
    @Test
    public void wordBreak2() {
        Assert.assertTrue(solution.wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));
    }

    /**
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    @Test
    public void wordBreak3() {
        Assert.assertFalse(solution.wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }

    /**
     * 示例 4：
     * <p>
     * 输入: s = "cars", wordDict = ["car","ca","rs"]
     * 输出: true
     */
    @Test
    public void wordBreak4() {
        Assert.assertFalse(solution.wordBreak("cars", Lists.newArrayList("car", "ca", "rs")));
    }
}