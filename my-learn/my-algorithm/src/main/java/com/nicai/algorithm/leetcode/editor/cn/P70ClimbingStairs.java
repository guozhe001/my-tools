package com.nicai.algorithm.leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1303 👎 0

/**
 * 爬楼梯
 *
 * @author nicai
 */
public class P70ClimbingStairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            // 新建数组，数组的下标是数字n，数组的值是当前的数字n对应的多少种方法
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    dp[i] = 1;
                } else if (i == 2) {
                    dp[i] = 2;
                } else {
                    // 爬到最后一个楼梯有两种方式，一次爬两格或者两次爬一格；把这两种可能性的所有方法相加就是当前的方法数量
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}