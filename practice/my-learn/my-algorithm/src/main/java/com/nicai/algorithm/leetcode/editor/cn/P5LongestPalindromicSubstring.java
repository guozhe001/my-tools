package com.nicai.algorithm.leetcode.editor.cn;
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


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author nicai
 */
public class P5LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            System.out.println("s=" + s);
            if (Objects.isNull(s) || s.length() <= 1) {
                return s;
            }
            /*
              # 分析：
              ## 回文子串:正着年的顺序和倒着念的顺序一样
              ## 结果字符串中没有相同的字符
              ## 以下为特殊情况
              1. 传入的字符串为null
              2. 传入的字符串为空即""
              3. 传入的字符串只有一个字符
              2. 传入的字符串只有两个字符
              3. 传入的字符串没有重复的字符串/
             */
            return solution(s);
        }

        // 最长公共字串的解法，但是不是最长的回文字串
        private String solution(String s) {
            char[] chars = s.toCharArray();
            char[] reversalChars = reversal(chars);
            int length = chars.length;
            Map<Integer, int[]> map = new HashMap<>();
            int maxLength = 0;
            // 记录当前的回文字串的长度
            int[][] dp = new int[length + 1][length + 1];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (chars[i] == reversalChars[j]) {
                        int currentLength = dp[i][j] + 1;
                        dp[i + 1][j + 1] = currentLength;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            map.put(maxLength, new int[]{i + 1, j + 1});
                        }
                    } else {
                        dp[i + 1][j + 1] = 0;
                    }
                    System.out.print(dp[i + 1][j + 1] + " ");
                }
                System.out.println();
            }
            int[] maxLengthCell = map.get(maxLength);
            int i = maxLengthCell[0];
            int j = maxLengthCell[1];
            StringBuilder stringBuilder = new StringBuilder();
            while (dp[i][j] > 0) {
                stringBuilder.append(chars[i - 1]);
                i--;
                j--;
            }
            return stringBuilder.toString();
        }

        private char[] reversal(char[] chars) {
            int length = chars.length;
            char[] result = new char[length];
            for (int i = 0; i < length; i++) {
                result[i] = chars[length - 1 - i];
            }
            return result;
        }

        /**
         * #方法1，循环字符串数组，依次取字符，然后在剩余的字符中从后往前查找此字符首次出现的下标
         * ## 如果能找到：此时回文子串的长度为两个下标的差 + 1
         * ### 记录最大的长度
         * ### 用map保存位置，key为长度，value为回文子串
         * ### 如果当前的最大长度大于历史的最大长度，更新最大长度
         * ### 如果当前的最大长度大于等于总长度减当前下标减1，则结束循环
         * ### 最终从map中get当前最大长度的值，返回
         * 如果找不到，继续下次循环
         *
         * @param s 字符串
         * @return 最长回文字串
         */
        private String solution1(String s) {
            char[] chars = s.toCharArray();
            int maxLength = 0;
            Map<Integer, String> lengthValueMap = new HashMap<>();
            for (int i = 0; i < chars.length - 1; i++) {
                // 当前的字符
                char currentChar = chars[i];
                // 定义当前字符的回文字符串的最大长度为1
                int length = 1;
                // 从当前位置的下一位出发，遍历整个字符数组，寻找第一个与当前的字符相同的字符
                for (int j = chars.length - 1; j > i; j--) {
                    char nextChar = chars[j];
                    // 如果找到了相同的字符，则计算两个字符的长度，并记录下标
                    if (nextChar == currentChar) {
                        // 当前回文字符串长度
                        length = j - i + 1;
                    }
                    if (length > maxLength) {
                        System.out.println(String.format("i=%s, j=%s, currentChar=%s, length=%s", i, j, currentChar, length));
                        maxLength = length;
                        lengthValueMap.put(length, String.valueOf(chars, i, length));
                        if (maxLength > 1) {
                            break;
                        }
                    }
                }
                if (maxLength >= chars.length - i - 1) {
                    break;
                }
            }
            return lengthValueMap.get(maxLength);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}