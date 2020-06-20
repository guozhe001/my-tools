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

import java.util.Arrays;

public class P4MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, nums, 0, nums1.length);
            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
            // 排序
            int[] sortedNums = sort(nums);
            int[] midNums = getMidNums(sortedNums);
            return ((midNums[0] + midNums[midNums.length - 1])) / 2.0;
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

        /**
         * 快速排序
         *
         * @param a
         * @return
         */
        public int[] sort(int[] a) {
            if (a.length < 2) {
                return a;
            }
            int jizhun = a[0];
            // 小于的位置
            int xiaoyuPosion = 0;
            // 大于的位置
            int dayuPosion = 0;
            int[] xiaoyu = new int[a.length];
            int[] dayu = new int[a.length];
            for (int i = 1; i < a.length; i++) {
                if (a[i] <= jizhun) {
                    xiaoyu[xiaoyuPosion] = a[i];
                    xiaoyuPosion++;
                } else {
                    dayu[dayuPosion] = a[i];
                    dayuPosion++;
                }
            }

            int[] result = new int[a.length];
            // System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)
            System.arraycopy(sort(Arrays.copyOf(xiaoyu, xiaoyuPosion)), 0, result, 0, xiaoyuPosion);
            result[xiaoyuPosion] = jizhun;
            System.arraycopy(sort(Arrays.copyOf(dayu, dayuPosion)), 0, result, xiaoyuPosion + 1, dayuPosion);
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}