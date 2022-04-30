package com.nicai.algorithm.leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1294 👎 0

public class P9PalindromeNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            while (true) {
                if (x == 0) {
                    return true;
                }
                int v = (int) Math.log10(x);
                if (v == 0) {
                    return true;
                }
                int high = (int) (x / Math.pow(10, v));
                int low = x % 10;
                if (high != low) {
                    return false;
                }
                // 掐头
                x = x - high * (int) Math.pow(10, v);
                // 如果去头之后得到的数字位数小于6位，说明有0存在;计算有多少个0
                int zeroCount = v - 1 - (int) Math.log10(x);
                // 去尾
                x = x / 10;
                for (int i = 0; i < zeroCount; i++) {
                    if (x % 10 != 0) {
                        return false;
                    }
                    x = x / 10;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}