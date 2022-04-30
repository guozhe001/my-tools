package com.nicai.algorithm.leetcode.editor.cn;
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 297 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author nicai
 */
public class P217ContainsDuplicate {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 判断是否有重复元素
         * 实现方式3：与方法2的区别就是把for循环改成while循环
         */
        public boolean containsDuplicate(int[] nums) {
            int length = nums.length;
            Set<Integer> set = new HashSet<>(length);
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int num = nums[i];
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
                int num1 = nums[j];
                if (set.contains(num1)) {
                    return true;
                }
                set.add(num1);
                i++;
                j--;
            }
            return false;
        }

        /**
         * 判断是否有重复元素
         * 实现方式2：此方法比方法1循环的次数少一半
         * 使用set保存已经出现过的数字
         * 然后使用for循环遍历n/2次，每次都取正序和倒序遍历的两个数值，如果set中包含当前数字，则说明重复
         */
        public boolean containsDuplicateDouble(int[] nums) {
            int length = nums.length;
            Set<Integer> set = new HashSet<>(length);
            for (int i = 0; i <= length / 2; i++) {
                int j = length - 1 - i;
                if (i != length / 2) {
                    int num = nums[i];
                    if (set.contains(num)) {
                        return true;
                    }
                    set.add(num);
                }
                if (j > i) {
                    int num1 = nums[j];
                    if (set.contains(num1)) {
                        return true;
                    }
                    set.add(num1);
                }
            }
            return false;
        }

        /**
         * 判断是否有重复元素
         * 实现方式1：直接使用set保存已经出现过的数字，然后正序遍历数组，如果set中包含当前数字，则说明重复
         */
        public boolean containsDuplicateUseSet(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int n : nums) {
                if (set.contains(n)) {
                    return true;
                }
                set.add(n);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}