package com.nicai.algorithm.leetcode.editor.cn;
//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 递归 
// 👍 22 👎 0

/**
 * 递归乘法
 *
 * @author nicai
 */
public class RecursiveMulitplyLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int multiply(int A, int B) {
            /*
             * 最终使用A个B相加，在递归的过程中如果A太大会导致栈太高，所以如果A比B大时反转使用B作为栈的高度
             */
            if (A > B) {
                int temp = B;
                B = A;
                A = temp;
            }
            if (A == 0 || B == 0) {
                return 0;
            } else if (A == 1) {
                return B;
            } else {
                int c = multiply(A - 1, B);
                if (Integer.MAX_VALUE - c < B) {
                    throw new IllegalArgumentException("数字太大乘法溢出");
                }
                return B + c;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}