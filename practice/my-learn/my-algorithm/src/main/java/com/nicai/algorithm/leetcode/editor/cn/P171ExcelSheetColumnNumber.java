package com.nicai.algorithm.leetcode.editor.cn;
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//... 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
//
// Related Topics 数学 字符串 👍 384 👎 0

import java.util.HashMap;
import java.util.Map;

public class P171ExcelSheetColumnNumber {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private final Map<String, Integer> map = new HashMap<>(32);

        public Solution() {
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            map.put("D", 4);
            map.put("E", 5);
            map.put("F", 6);
            map.put("G", 7);
            map.put("H", 8);
            map.put("I", 9);
            map.put("J", 10);
            map.put("K", 11);
            map.put("L", 12);
            map.put("M", 13);
            map.put("N", 14);
            map.put("O", 15);
            map.put("P", 16);
            map.put("Q", 17);
            map.put("R", 18);
            map.put("S", 19);
            map.put("T", 20);
            map.put("U", 21);
            map.put("V", 22);
            map.put("W", 23);
            map.put("X", 24);
            map.put("Y", 25);
            map.put("Z", 26);
        }

        public int titleToNumber(String columnTitle) {
            int result = 0;
            char[] chars = columnTitle.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                result = result + map.get(String.valueOf(chars[i])) * (int) Math.pow(26, chars.length - i - 1);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}