package com.nicai.algorithm.leetcode.editor.cn;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
// 输出: "6"
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
// 输出: "56088"
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 489 👎 0

/**
 * 字符串相乘
 *
 * @author nicai
 */
public class P43MultiplyStrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            /**
             * 转换成数组，然后让
             */
            int[] ints1 = getIntArray(num1);
            int[] ints2 = getIntArray(num2);
            return null;
        }

        private int[] getIntArray(String num) {
            char[] chars = num.toCharArray();
            int[] result = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                result[i] = chars[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}