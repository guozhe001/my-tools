package com.nicai.algorithm.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 773 👎 0

/**
 * 移动零
 *
 * @author nicai
 */
public class P283MoveZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 移动非0的数字解决问题
         *
         * @param nums 待移动的数组
         */
        public void moveZeroes(int[] nums) {
            int notZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swap(nums, notZeroIndex++, i);
                }
            }
        }

        /**
         * 真实的移动0来解决问题
         *
         * @param nums 待移动的数组
         */
        public void moveZeroesMoveZero(int[] nums) {
            if (nums.length < 2) {
                return;
            }
            int slow = 0;
            int fast = 1;
            while (fast < nums.length) {
                if (nums[slow] == 0) {
                    while (fast < nums.length - 1 && nums[fast] == 0) {
                        fast++;
                    }
                    swap(nums, slow, fast);
                }
                slow++;
                fast++;
            }
        }

        /**
         * 两次for循环解决方法
         *
         * @param nums 待移动的数组
         */
        public void moveZeroesTwoLoop(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 0) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > 0) {
                            swap(nums, i, j);
                            break;
                        }
                    }
                }
            }
        }

        /**
         * 数组中指定下标的两个元素交换
         *
         * @param nums 数组
         * @param i    需要交换的下标i
         * @param j    需要交换的下标j
         */
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}