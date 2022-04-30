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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 字符串相乘
 *
 * @author nicai
 */
public class P43MultiplyStrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            // 转换成数组，然后让数组相乘
            List<String> multiply = multiply(getIntArray(num1), getIntArray(num2));
            return addAllString(multiply);
        }

        /**
         * 把数值相加
         *
         * @param strings 包含数字的字符串列表
         * @return 所有的字符串之和
         */
        private String addAllString(List<String> strings) {
            if (strings.size() == 1) {
                return strings.get(0);
            } else {
                List<String> first = new ArrayList<>();
                first.add(strings.get(0));
                strings.remove(0);
                return add(addAllString(first), addAllString(strings));
            }
        }

        /**
         * 两个字符串相加
         *
         * @param str1 字符串1
         * @param str2 字符串2
         * @return 相加后的字符串
         */
        private String add(String str1, String str2) {
            return add(stringToStack(str1), stringToStack(str2));
        }

        /**
         * 两个数组相加
         *
         * @param stack1 栈1
         * @param stack2 栈2
         * @return 相加后的字符串
         */
        private String add(Stack<Integer> stack1, Stack<Integer> stack2) {
            int max = Math.max(stack1.size(), stack2.size());
            // 保存进位的栈
            Stack<Integer> carryStack = new Stack<>();
            Stack<Integer> resultStack = new Stack<>();
            for (int i = 0; i < max; i++) {
                int n1 = stack1.isEmpty() ? 0 : stack1.pop();
                int n2 = stack2.isEmpty() ? 0 : stack2.pop();
                int carry = carryStack.isEmpty() ? 0 : carryStack.pop();
                int result = n1 + n2 + carry;
                carryStack.push(result / 10);
                resultStack.push(result % 10);
            }
            resultStack.push(carryStack.pop());
            return stackToString(resultStack);
        }

        /**
         * 数组相乘
         *
         * @param ints1 数组1
         * @param ints2 数组2
         * @return 数组相乘之后的结果
         */
        private List<String> multiply(int[] ints1, int[] ints2) {
            // 保存进位的栈
            Stack<Integer> carryStack = new Stack<>();
            List<String> numStrings = new ArrayList<>();
            for (int i = ints1.length - 1; i >= 0; i--) {
                int int1 = ints1[i];
                Stack<Integer> resultStack = new Stack<>();
                for (int k = 0; k < ints1.length - 1 - i; k++) {
                    resultStack.push(0);
                }
                for (int j = ints2.length - 1; j >= 0; j--) {
                    int int2 = ints2[j];
                    int result = int1 * int2;
                    int carry = carryStack.isEmpty() ? 0 : carryStack.pop();
                    result = result + carry;
                    int remainder = result % 10;
                    if (j == 0) {
                        resultStack.push(remainder);
                        if (result / 10 > 0) {
                            resultStack.push(result / 10);
                        }
                    } else {
                        resultStack.push(remainder);
                        carryStack.push(result / 10);
                    }
                }
                numStrings.add(stackToString(resultStack));
            }
            return numStrings;
        }

        private String stackToString(Stack<Integer> stack) {
            StringBuilder sb = new StringBuilder();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer pop = stack.pop();
                if (pop == 0 && sb.length() == 0 && i < size - 1) {
                    continue;
                }
                sb.append(pop);
            }
            return sb.toString();
        }

        private int[] getIntArray(String num) {
            char[] chars = num.toCharArray();
            int[] result = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                result[i] = Integer.parseInt(String.valueOf(chars[i]));
            }
            return result;
        }

        private Stack<Integer> stringToStack(String num) {
            char[] chars = num.toCharArray();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                stack.push(Integer.parseInt(String.valueOf(chars[i])));
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}