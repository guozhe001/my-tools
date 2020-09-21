package com.nicai.algorithm.leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
// 输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
// 输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2197 👎 0

import java.util.Objects;
import java.util.Stack;

/**
 * 整数反转
 *
 * @author nicai
 */
public class P7ReverseInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(x);
            Stack<Integer> stack = new Stack<>();
            // 是否为负值
            boolean negative = false;
            for (char aChar : s.toCharArray()) {
                if (Objects.equals('-', aChar)) {
                    negative = true;
                } else {
                    stack.push(Integer.parseInt(String.valueOf(aChar)));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (stringBuilder.length() == 0 && 0 == pop) {
                    continue;
                }
                stringBuilder.append(pop);
            }
            try {
                int i = Integer.parseInt(stringBuilder.toString());
                return negative ? Math.negateExact(i) : i;
            } catch (Exception e) {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}