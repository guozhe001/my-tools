package com.leetcode.editor.cn;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// 示例 3:
//
// nums1 = [1, 3]
//nums2 = [2, 4]
//
//则中位数是 (3 + 2)/2 = 2.5
//
// 示例 4:
//
// nums1 = [1, 3]
//nums2 = [2, 4]
//
//则中位数是 (3 + 2)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

public class P4MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] midNums1 = getMidNums(nums1);
            int[] midNums2 = getMidNums(nums2);
            // 现在有了两个新的数组，这两个数组的长度在1和2之间
            // 合并两个数组，然后让他们排序，排序之后再获取新的数组的中位数
            int[] nums = new int[midNums1.length + midNums2.length];
            // 排序
            int[] sortedNums = erfenpaixu(nums);
            int[] midNums = getMidNums(sortedNums);
            return (midNums[0] + midNums[midNums.length - 1]) >> 1;
        }

        private int[] erfenpaixu(int[] nums) {

            return new int[0];
        }

        private int[] getMidNums(int[] nums1) {
            int[] midNums;
            int i = nums1.length / 2;
            // 如果长度能够被2整出，这个数组无法找到中间的一个值，则取中间的两个值
            if (nums1.length % 2 == 0) {
                midNums = new int[2];
                /*
                nums长度 ： nums除以2的值 ： 最终取值的两个下标
                2 : 1 : 0,1
                4 : 2 : 1,2
                6 : 3 : 2,3
                 */
                midNums[0] = nums1[i - 1];
                midNums[1] = nums1[i];
            } else {
                /*
                nums长度 ： nums除以2的值 ： 最终取值的下标
                3 : 1 : 1
                1 : 0 : 0
                15 : 7 : 7
                 */
                midNums = new int[1];
                midNums[0] = nums1[i];
            }
            return midNums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}