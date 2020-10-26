package com.nicai.algorithm.leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2566 👎 0

/**
 * 最大子序和
 *
 * @author nicai
 */
public class P53MaximumSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // 动态规划的表格画法：行：0，1，2，3，4，5。。。nums.length-1；列：：0，1，2，3，4，5。。。nums.length-1；对应的表格表示当前的字数组的和的最大值
            int[] dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                // 如果只有一个元素
                if (i == 0) {
                    dp[i + 1] = nums[i];
                } else {
                    dp[i + 1] = Math.max(dp[i], Math.max(nums[i], nums[i] + dp[i]));
                }
            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}