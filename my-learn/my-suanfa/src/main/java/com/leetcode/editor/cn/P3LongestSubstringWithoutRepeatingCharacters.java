package com.leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (null == s) {
                throw new NullPointerException("s不能为null");
            }
            if ("".equals(s)) {
                return 0;
            }
            char[] chars = s.toCharArray();
            return getUnRepeatMap(chars).keySet().stream().max(Integer::compareTo).orElse(1);
        }

        Map<Integer, Integer> getUnRepeatMap(char[] chars) {
            // 不重复的字符串长度，key为长度;value没有用
            Map<Integer, Integer> unRepeatLength = new HashMap<>();
            int start = 0;
            do {
                start = getNoRepeatMap(chars, start, unRepeatLength);
            } while (start != chars.length);
            return unRepeatLength;
        }

        /**
         * 从下标为i开始向后获取不重复的字符
         *
         * @param chars
         * @param start
         * @param unRepeatLength
         * @return 下次开始循环的下标
         */
        int getNoRepeatMap(char[] chars, int start, Map<Integer, Integer> unRepeatLength) {
            if (start < chars.length) {
                Map<Character, Integer> temp = new HashMap<>();
                for (int j = start; j < chars.length; j++) {
                    // 如果不包含此key，说明还没有重复
                    if (!temp.containsKey(chars[j])) {
                        temp.put(chars[j], j);
                    } else {
                        // 否则如果已经包含了此字符，说明重复了
                        System.out.println(String.format("start=%s char = %s is repeat at index= %s and index= %s ", start, chars[j], temp.get(chars[j]), j));
                        // 长度放在map中
                        unRepeatLength.put(j - temp.get(chars[start]), 1);
                        if (j == chars.length - 1) {
                            break;
                        }
                        // 继续从重复的字符的下一位继续查找
                        return temp.get(chars[j]) + 1;
                    }
                }
                unRepeatLength.put(temp.size(), 1);
            }
            return chars.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}