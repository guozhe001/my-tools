package com.nicai.algorithm.leetcode.editor.cn;
//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。 
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 读入字符串并丢弃无用的前导空格 
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 
//2 开始）。 
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
// 返回整数作为最终结果。 
// 
//
// 注意： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
//
// 示例 2： 
//
// 
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
// 
//
// 示例 3： 
//
// 
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
//
// Related Topics 字符串 👍 1603 👎 0

import edu.princeton.cs.algs4.In;

import java.util.Objects;

public class P8StringToIntegerAtoi {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        char zero = '0';
        char nine = '9';

        public int myAtoi(String s) {
            // 如果是null或空字符串
            if (Objects.isNull(s) || s == "") {
                return 0;
            }
            // 删除前导空格
            s = s.trim();
            boolean fushu = false;
            // 如果还有长度并且有正负号，则去掉正负号，并记录正负
            if (s.length() > 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
                fushu = s.charAt(0) == '-';
                s = s.substring(1);
            }
            // 如果正负号后面没有值或者后面不是数字，则返回0
            if (s.length() == 0 || s.charAt(0) < zero || s.charAt(0) > nine) {
                return 0;
            }
            int i = 0, result = 0;
            while (i < s.length() && s.charAt(i) >= zero && s.charAt(i) <= nine) {
                int temp = s.charAt(i) - zero;
                temp = fushu ? temp * -1 : temp;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + temp;
                i++;
            }
            return result;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


//    class Solution {
//
//        private final char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//
//        public int myAtoi(String s) {
//            StringBuilder stringBuilder = new StringBuilder();
//            int index = 0;
//            for (char c : s.toCharArray()) {
//                if (isNum(c)) {
//                    if (index == 0 && c == '0') {
//                    } else {
//                        stringBuilder.append(c);
//                        index++;
//                    }
//                } else {
//                    if (index > 0) {
//                        break;
//                    } else {
//                        if (c == '-') {
//                            stringBuilder.append("-");
//                            index++;
//                        } else if (c == ' ') {
//                            continue;
//                        } else {
//                            break;
//                        }
//                    }
//
//                }
//            }
//            String s1 = stringBuilder.toString();
//
//            return toInt(s1);
//        }
//
//        private int toInt(String s1) {
//            return Objects.equals("", s1) ? 0 : Integer.parseInt(s1);
//        }
//
//        public boolean isNum(char c) {
//            for (char n : numbers) {
//                if (Objects.equals(n, c)) {
//                    return Boolean.TRUE;
//                }
//            }
//            return Boolean.FALSE;
//        }
//    }

}