package com.nicai.algorithm.leetcode.editor.cn;
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 204 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 存在重复元素 II
 *
 * @author nicai
 */
public class P219ContainsDuplicateIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 一次for循环：时间复杂度O(n)
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (null == nums || nums.length == 0 || k <= 0) {
                return false;
            }
            // key为重复的数字，value为数字对应的下标，如果有重复数字，则保存下标较大的下标
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                Integer oldIndex = map.get(num);
                // 如果有旧数字，则判断下标的差的绝对值是否小于等于k，如果等于则返回true，否则更新数字的下标为当前的下标
                if (Objects.nonNull(oldIndex) && i - oldIndex <= k) {
                    return true;
                }
                map.put(num, i);
            }
            return false;
        }

        /**
         * 两次for循环解决方式,时间复杂度O(n!)
         */
        public boolean containsNearbyDuplicate2TimesForLoop(int[] nums, int k) {
            if (null == nums || nums.length == 0 || k <= 0) {
                return false;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                int num1 = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int num2 = nums[j];
                    // 如果两个位置的数字相等，则说明有重复的数字，如果重复数字的下标差的绝对值小于等于k，则返回true
                    if (num1 == num2 && j - i <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}