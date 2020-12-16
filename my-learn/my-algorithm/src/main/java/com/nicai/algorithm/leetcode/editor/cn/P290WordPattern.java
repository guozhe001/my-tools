package com.nicai.algorithm.leetcode.editor.cn;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 267 👎 0

import java.util.HashMap;
import java.util.Map;

public class P290WordPattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            char[] patternChars = pattern.toCharArray();
            if (patternChars.length != words.length) {
                return false;
            }
            //key为pattern的字母，value为该字母对应的word
            Map<String, String> patternMap = new HashMap<>(pattern.length());
            // key为word，value为pattern的字母
            Map<String, String> wordMap = new HashMap<>(pattern.length());
            for (int i = 0; i < patternChars.length; i++) {
                String word = words[i];
                String key = String.valueOf(patternChars[i]);
                // 如果map中已经存在此key，则验证patternMap和wordMap保存的数据可以相互映射
                if (patternMap.containsKey(key)) {
                    // 如果不相同，直接返回false
                    if (!patternMap.get(key).equals(word) || !key.equals(wordMap.get(word))) {
                        return false;
                    }
                } else {
                    // 如果单词key不存在，则key对应的word也不应该存在，如果存在则不符合规律
                    if (wordMap.containsKey(word)) {
                        return false;
                    }
                    patternMap.put(key, word);
                    wordMap.put(word, key);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}