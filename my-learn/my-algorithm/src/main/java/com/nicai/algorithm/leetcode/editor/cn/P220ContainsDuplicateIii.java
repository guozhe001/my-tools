package com.nicai.algorithm.leetcode.editor.cn;
//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 241 👎 0

/**
 * 存在重复元素 III
 *
 * @author nicai
 */
public class P220ContainsDuplicateIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//            for (int i = 0; i < nums.length; ++i) {
//                for (int j = Math.max(i - k, 0); j < i; ++j) {
//                    if (Math.abs(nums[i] - nums[j]) <= t) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }

        /**
         * 两次for循环，但是无法解决溢出问题
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            for (int i = 0; i < nums.length - 1; i++) {
                int num1 = nums[i];
                // 第二次循环只需要查找距离i区间小于等于k的下标即可
                for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                    int num2 = nums[j];
                    if (Math.abs(num2 - num1) <= t && j - i <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
