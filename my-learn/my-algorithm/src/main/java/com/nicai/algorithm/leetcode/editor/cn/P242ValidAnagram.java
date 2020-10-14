package com.nicai.algorithm.leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 262 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 有效的字母异位词
 *
 * @author nicai
 */
public class P242ValidAnagram {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (null == s || null == t) {
                return false;
            }
            /*
             * 需要两个判断可以判定为字母异位词：
             * 1、s字符串中的字符以及个数和t中的字符以及个数相同
             * 2、s字符串中的字符顺序和t中的字符顺序不完全相同
             */
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            int length = charS.length;
            if (length != charT.length) {
                return false;
            }
            if (length == 0) {
                return true;
            }
            // 保存字符出现的次数
            Map<String, Integer> charCountS = new HashMap<>(length);
            // 保存字符出现的次数
            Map<String, Integer> charCountT = new HashMap<>(length);

            for (int i = 0; i < length; i++) {
                count(charS, i, charCountS);
                count(charT, i, charCountT);
            }
            for (Map.Entry<String, Integer> entry : charCountS.entrySet()) {
                // 如果某个字符出现的次数不一致，则两个定不是异位词
                if (!Objects.equals(charCountT.get(entry.getKey()), entry.getValue())) {
                    return false;
                }
            }
            return true;
        }

        private void count(char[] charArray, int index, Map<String, Integer> charCount) {
            String charI = String.valueOf(charArray[index]);
            Integer chariCount = charCount.get(charI);
            charCount.put(charI, Objects.isNull(chariCount) ? 0 : chariCount + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}