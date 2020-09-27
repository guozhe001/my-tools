package com.nicai.algorithm.leetcode.editor.cn;
//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
// 输出: true
// 解释: 6 = 2 × 3
//
// 示例 2: 
//
// 输入: 8
// 输出: true
// 解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
// 输出: false
// 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 152 👎 0

/**
 * 丑数
 *
 * @author nicai
 */
public class P263UglyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int TWO = 2;
        private static final int THREE = 3;
        private static final int FIVE = 5;
        private static final int ZERO = 0;

        public boolean isUgly(int num) {
            if (num <= ZERO) {
                return false;
            }
            if (num == 1 || num == TWO || num == THREE || num == FIVE) {
                return true;
            }
            if (num % TWO == ZERO) {
                return isUgly(num / TWO);
            } else if (num % THREE == ZERO) {
                return isUgly(num / THREE);
            } else if (num % FIVE == ZERO) {
                return isUgly(num / FIVE);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}