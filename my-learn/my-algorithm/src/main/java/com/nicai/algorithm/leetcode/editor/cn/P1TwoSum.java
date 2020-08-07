package com.nicai.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
public class P1TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            // key为数字，value为此数字在nums中对应的下标，如果数字重复value为下标较小的那个
            Map<Integer, Integer> map = new HashMap<>(2);
            for (int i = 0; i < nums.length; i++) {
                // 当前的数字
                int num = nums[i];
                // 差数
                int temp = target - num;
                // 如果差数存在，并且不是当前的下标
                if (map.containsKey(temp) && map.get(temp) != i) {
                    result[0] = map.get(temp);
                    result[1] = i;
                    return result;
                }
                if (!map.containsKey(num)) {
                    map.put(num, i);
                }
            }
            throw new IllegalArgumentException("列表中不存在两个数字之和等于目标值");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

//    /**
//     * 暴力解决方法
//     * 时间复杂度为n的n次幂
//     */
//    class Solution1 {
//        public int[] twoSum(int[] nums, int target) {
//            int[] result = new int[2];
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        result[0] = i;
//                        result[1] = j;
//                        return result;
//                    }
//                }
//            }
//            throw new IllegalArgumentException("列表中不存在两个数字之和等于目标值");
//        }
//    }

}