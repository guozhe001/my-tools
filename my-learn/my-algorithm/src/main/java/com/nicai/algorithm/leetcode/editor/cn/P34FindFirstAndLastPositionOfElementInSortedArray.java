package com.nicai.algorithm.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 731 👎 0

import java.util.Arrays;

/**
 * @author nicai
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            Arrays.fill(result, -1);
            if (0 == nums.length) {
                return result;
            }
            int search = search(nums, target, 0, nums.length - 1);
            if (search < 0) {
                return result;
            }
            int minIndex = search;
            int maxIndex = search;
            while (minIndex > 0 && nums[minIndex - 1] == target) {
                minIndex--;
            }
            while (maxIndex < nums.length - 1 && nums[maxIndex + 1] == target) {
                maxIndex++;
            }
            result[0] = minIndex;
            result[1] = maxIndex;
            return result;
        }

        /**
         * 二分查找
         *
         * @param nums   数组
         * @param target 目标值
         * @return 返回目标值的下标
         */
        public int search(int[] nums, int target, int startIndex, int endIndex) {
            int result = -1;
            if (endIndex - startIndex < 2) {
                if (target == nums[startIndex]) {
                    return startIndex;
                } else if (target == nums[endIndex]) {
                    return endIndex;
                }
                return result;
            }
            // 中间位置
            int middleIndex = (startIndex + endIndex) / 2;
            int middleValue = nums[middleIndex];
            if (middleValue == target) {
                return middleIndex;
            } else if (middleValue < target) {
                return search(nums, target, middleIndex, endIndex);
            } else {
                return search(nums, target, startIndex, middleIndex);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}