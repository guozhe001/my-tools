package com.nicai.algorithm.leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 795 👎 0

/**
 * 乘积最大子数组
 *
 * @author nicai
 */
public class P152MaximumProductSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // TODO 超时，待优化
        public int maxProduct(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(multiplication(nums, j - 1, i - 1), dp[j]));
                }
            }
            return dp[nums.length];
        }

        /**
         * 数组的下标j至下标i的所有元素相乘
         *
         * @param nums 数组
         * @param j    下标j
         * @param i    下标i
         * @return 数组的下标j至下标i的所有元素相乘
         */
        private int multiplication(int[] nums, int j, int i) {
            int result = 1;
            while (j <= i) {
                result = result * nums[j];
                j++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}