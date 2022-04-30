package com.nicai.algorithm.leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 692 👎 0

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 *
 * @author nicai
 */
public class P139WordBreak {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            char[] chars = s.toCharArray();
            //动态规划的数组，下标为字符串的长度，值为1的时候说明可以被拆分，值为0的时候说明不可以被拆分
            boolean[] dp = new boolean[chars.length + 1];
            for (int i = 1; i <= chars.length; i++) {
                if (wordDict.contains(String.valueOf(Arrays.copyOf(chars, i)))) {
                    dp[i] = true;
                } else {
                    // 如果整个词不在单词列表中，则判断这个词的部分是否在单词列表中
                    int j = i - 1;
                    // 从后往前，分割字符串，判断是否有可以拆分的情况
                    while (j >= 1) {
                        if (dp[j] && wordDict.contains(String.valueOf(Arrays.copyOfRange(chars, j, i)))) {
                            dp[i] = true;
                            break;
                        }
                        j--;
                    }
                }
            }
            return dp[chars.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}