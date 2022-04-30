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

import java.util.HashSet;
import java.util.Set;

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

        /**
         * 快慢双指针
         *
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            // 定义快的指针，每次走两步
            int fast = sumPow(n);
            // 如果快指针达到1，或者快指针追上慢指针则停止循环
            while (fast != ONE && fast != n) {
                // 快指针每次走两步
                fast = sumPow(sumPow(fast));
                n = sumPow(n);
            }
            return fast == ONE;
        }

        /**
         * 使用hashSet保存已经出现的数字，如果再次出现则说明出现循环
         *
         * @param n 判断是否happy的数字
         * @return 是否happy
         */
        public boolean isHappyHashSet(int n) {
            Set<Integer> set = new HashSet<>();
            while (n != ONE) {
                // 如果进入到循环中，则结束
                if (set.contains(n)) {
                    break;
                }
                set.add(n);
                n = sumPow(n);
            }
            return n == ONE;
        }

        /**
         * 循环100次或者回归到1
         *
         * @param n 判断是否happy的数字
         * @return 是否happy
         */
        public boolean isHappyHundredTimes(int n) {
            int i = 0;
            // 这种方法只有在确定一个数字的各个位数的平方和回归到1的时的循环次数小于100时才能用，否则不严谨
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