package com.nicai.algorithm.leetcode.editor.cn;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 276 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Excel表列名称
 *
 * @author nicai
 */
public class P168ExcelSheetColumnTitle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 字母个数
         */
        private static final int WORD_NUM = 26;

        /**
         * 字母数组
         */
        private final String[] word = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        /**
         * 前26excel列的名称，key为列的顺序，value为列名
         */
        private final Map<Integer, String> map = new HashMap<>(WORD_NUM);

        Solution() {
            IntStream.range(0, WORD_NUM).forEach(i -> map.put(i + 1, word[i]));
        }

        public String convertToTitle(int n) {
            int i = n % WORD_NUM;
            if (n <= WORD_NUM) {
                return map.get(n);
            } else if (i == 0) {
                return convertToTitle(n / WORD_NUM - 1) + map.get(WORD_NUM);
            } else {
                return convertToTitle(n / WORD_NUM) + convertToTitle(i);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}