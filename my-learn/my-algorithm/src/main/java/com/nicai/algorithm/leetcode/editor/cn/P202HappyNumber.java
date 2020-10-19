package com.nicai.algorithm.leetcode.editor.cn;
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学 
// 👍 464 👎 0

/**
 * 快乐数
 *
 * @author nicai
 */
public class P202HappyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int ONE = 1;
        private static final int TEN = 10;
        private static final int MAX_CYCLE_TIMES = 100;

        public boolean isHappy(int n) {
            int i = 0;
            while (n != ONE && i++ <= MAX_CYCLE_TIMES) {
                n = sumPow(n);
            }
            return n == ONE;
        }

        /**
         * 数字的各个位上的数字的平方之和
         *
         * @param n 数字
         * @return 数字n各个位上的数字的平方之和
         */
        private int sumPow(int n) {
            int sum = 0;
            while (n > 0) {
                int i = n % TEN;
                sum += i == 0 ? i : i * i;
                n = n / TEN;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}