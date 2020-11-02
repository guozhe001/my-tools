package com.nicai.algorithm.leetcode.editor.cn;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1102 👎 0

/**
 * 打家劫舍
 *
 * @author nicai
 */
public class P198HouseRobber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            /*
             * 初始化动态规划的数组，此时的数组中的值都是0
             * 此数组的下标为偷取的前n个房屋的数量
             * 此数组的值为偷取的前n个房屋可以偷取的金钱最大值
             * 如果dp[5] = 100；表示偷取前面的5家房屋，最多可以偷取100刀
             */
            int[] dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                int dpIndex = i + 1;
                // 如果只偷第一个房子
                if (i == 0) {
                    dp[dpIndex] = nums[i];
                } else if (i == 1) {
                    // 如果只偷前两个房子
                    dp[dpIndex] = Math.max(nums[i], nums[i - 1]);
                } else {
                    /*
                     * 此时有两种选择:1、偷当前的房屋；2、不偷当前的房屋，两种选择取最大值
                     * 如果选择1，则要计算当前房屋的金钱与当前房屋前一个不相邻的所有房屋的金钱价值
                     * 如果选择2，则直接取当前房屋之前的所有房屋能够偷的金钱最大值
                     */
                    dp[dpIndex] = Math.max(nums[i] + dp[i - 1], dp[i]);
                }
            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}