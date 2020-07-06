package com.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2391 👎 0

import java.util.Objects;

public class P5LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (Objects.isNull(s)) {
                return s;
            }
            /*
              # 分析：
              ## 回文子串，即第一个字母和第最后个字母相同
              ## 结果字符串中没有相同的字符
              ## 以下为特殊情况
              1. 传入的字符串为null
              2. 传入的字符串为空即""
              3. 传入的字符串只有一个字符
              2. 传入的字符串只有两个字符
              3. 传入的字符串没有重复的字符串
              ## 传入的字符串最大长度不超过1000，所以可以用
             */
            return solution1(s);
        }


    }

    /**
     * #方法1，循环字符串数组，依此取字符，然后在剩余的字符中查找此字符首次出现的下标
     * ## 如果能找到：此时回文子串的长度为下标+2
     * ### 并用map1保存长度，key为字符，value为长度
     * ### 用map2保存位置，key为长度，value为回文子串
     * ### 如果当前的最大长度大于历史的最大长度，更新最大长度
     * ### 如果当前的最大长度大于等于总长度减当前下标减1，则结束循环
     * ### 最终从map2中get当前最大长度的值，返回
     * 如果找不到，继续下次循环
     *
     * @param s 字符串
     * @return 最长回文字串
     */
    private String solution1(String s) {
        char[] chars = s.toCharArray();
//        Map<String,>
        for (int i = 0; i < chars.length - 1; i++) {

        }
        return null;
    }
//leetcode submit region end(Prohibit modification and deletion)

}