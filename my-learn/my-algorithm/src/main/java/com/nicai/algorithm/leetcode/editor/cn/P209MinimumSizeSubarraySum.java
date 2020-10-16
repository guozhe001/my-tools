package com.nicai.algorithm.leetcode.editor.cn;
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 474 👎 0

import java.util.Objects;

/**
 * 长度最小的子数组
 *
 * @author nicai
 */
public class P209MinimumSizeSubarraySum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (Objects.isNull(nums) || nums.length == 0) {
                return 0;
            }
            int minSubArrayLen = 0;
            if (sumBigThanTarget(nums, s)) {
                minSubArrayLen = nums.length;
                // 如果数组还能继续分割，则继续使用二分法分割获取子数组的最小长度
                if (minSubArrayLen > 1) {
                    int half = nums.length / 2;
                    int leftSubArrayLen = minSubArrayLen(s, sub(nums, 0, half));
                    int rightSubArrayLen = minSubArrayLen(s, sub(nums, half, nums.length - half));
                    if (leftSubArrayLen == 0 && rightSubArrayLen == 0) {
                        int i = half / 2;
                        leftSubArrayLen = minSubArrayLen(s, sub(nums, 0, half + half));
                    } else {
                        minSubArrayLen = leftSubArrayLen == 0 ? minSubArrayLen : Math.min(leftSubArrayLen, minSubArrayLen);
                        minSubArrayLen = rightSubArrayLen == 0 ? minSubArrayLen : Math.min(rightSubArrayLen, minSubArrayLen);
                    }
                }
            }
            return minSubArrayLen;
        }

        /**
         * 获取数组的子数组
         *
         * @param nums       原数组
         * @param startIndex 子数组的起始index
         * @param length     子数组的长度
         * @return 子数组
         */
        private int[] sub(int[] nums, int startIndex, int length) {
            int[] sub = new int[length];
            System.arraycopy(nums, startIndex, sub, 0, length);
            return sub;
        }

        /**
         * 加和
         *
         * @param nums   待加和的数组
         * @param target 待比较的数字
         * @return 数组所有元素之和
         */
        private boolean sumBigThanTarget(int[] nums, int target) {
            int sum = 0;
            if (nums.length == 1) {
                return nums[0] >= target;
            } else {
                int i = 0;
                int j = nums.length - 1;
                while (i <= j) {
                    sum = nums[i] + (i == j ? 0 : nums[j]) + sum;
                    if (sum >= target) {
                        return true;
                    }
                    i++;
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}