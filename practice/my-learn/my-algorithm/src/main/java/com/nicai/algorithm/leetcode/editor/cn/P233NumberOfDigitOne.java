package com.nicai.algorithm.leetcode.editor.cn;
//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 示例: 
//
// 输入: 13
//输出: 6 
//解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。 
// Related Topics 数学 
// 👍 175 👎 0

import java.util.stream.IntStream;

/**
 * 数字 1 的个数
 *
 * @author nicai
 */
public class P233NumberOfDigitOne {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         *
         */
        public int countDigitOne(int n) {
            /*
             * # 如果一个数字是个位数:(m==0 ? 0 : 1)
             * # 如果一个数字是两位数:
             * ## n为十位数：1m，则结果为：((m+1) + 1 + 0) + (m==0 ? 0 : 1)
             * ## n为十位数：2m，则结果为：(11 + 1 + 0) + (m==0 ? 0 : 1)
             * ## n为十位数：3m，则结果为：(11 + 1 + 1) + (m==0 ? 0 : 1)
             * ## n为十位数：4m，则结果为：(11 + 1 + 2) + (m==0 ? 0 : 1)
             * ## n为十位数：5m，则结果为：(11 + 1 + 3) + (m==0 ? 0 : 1)
             * ## n为十位数：6m，则结果为：(11 + 1 + 4) + (m==0 ? 0 : 1)
             * ## 总结公式为两位数：
             */
            int count = 0;
            if (n <= 0) {
                return 0;
            }
            int i = n / 10;
            // 除以10等于0，说明n是个位数
            if (i == 0) {
                count = 1;
            }
            // 除以10小于10，说明n是十位数
            if (i < 10) {
                // 个位数j
                int m = n % 10;
                if (i == 1) {
                    count = ((m + 1) + 1) + (m == 0 ? 0 : 1);
                } else {
                    count = (12 + (i - 2)) + (m == 0 ? 0 : 1);
                }
            }
            return count;
        }

        /**
         * 使用for循环，遍历所有的小于等于n的数字，逐个计算每个数字1的个数，最终把结果相加，
         * 此方法效率太慢，数字大的时候for循环的次数为n次，计算所有数字的包含1的个数，非常浪费
         */
        public int countDigitOneForLoop(int n) {
            return IntStream.range(0, n + 1).map(num -> countDigitOne(String.valueOf(num))).sum();
        }

        /**
         * 递归方式，方法调用栈的高度等于传入的数值n，在数值较大时会报StackOverflowError错误，所以此方法不可取
         */
        public int countDigitOneRecursive(int n) {
            if (n <= 0) {
                return 0;
            } else if (n <= 9) {
                return 1;
            } else {
                return countDigitOne(String.valueOf(n)) + countDigitOne(n - 1);
            }
        }

        private int countDigitOne(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if ('1' == c) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}