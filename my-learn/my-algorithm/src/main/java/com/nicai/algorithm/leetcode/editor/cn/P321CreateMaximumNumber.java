package com.nicai.algorithm.leetcode.editor.cn;
//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 242 👎 0

import java.util.ArrayList;
import java.util.List;

public class P321CreateMaximumNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] ints = new int[k];
            /*
             * 分步骤解决此问题
             * 1、先算出nums1出1个数，2个数、3个数一直到min(k, nums1.length)个数时的最大值
             * 2、再算出nums2出1个数，2个数、3个数一直到min(k, nums2.length)个数时的最大值
             * 3、再算merge到一起？
             */
            // 1、先算出nums1出1个数，2个数、3个数一直到min(k, nums1.length)个数时的最大值
            int[][] dp1 = dp(nums1, k);
            int[][] dp2 = dp(nums2, k);
            return dp1.length > dp2.length ? merge(dp1, dp2, k) : merge(dp2, dp1, k);
        }

        private int[][] dp(int[] nums1, int k) {
            int min = Math.min(nums1.length, k);
            int[][] dp = new int[min + 1][min];
            for (int i = 1; i <= min; i++) {
                dp[i] = findMaxNumber(nums1, i);
            }
            return dp;
        }


        private int[] merge(int[] nums1, int[] nums2, int length) {
            int[] ints = new int[length];
            int nums1Index = 0;
            int nums2Index = 0;
            for (int i = 0; i < ints.length; i++) {
                if (nums1Index >= nums1.length) {
                    ints[i] = nums2[nums2Index++];
                } else if (nums2Index >= nums2.length) {
                    ints[i] = nums1[nums1Index++];
                } else if (nums1[nums1Index] > nums2[nums2Index]) {
                    ints[i] = nums1[nums1Index++];
                } else if (nums1[nums1Index] < nums2[nums2Index]) {
                    ints[i] = nums2[nums2Index++];
                } else {
                    if (nums1Index == nums1.length - 1 && nums2Index == nums2.length - 1) {
                        ints[i] = nums2[nums2Index++];
                    } else if (nums1Index == nums1.length - 1 && nums2Index < nums2.length - 1) {
                        ints[i] = nums2[nums2Index++];
                    } else if (nums1Index < nums1.length - 1 && nums2Index == nums2.length - 1) {
                        ints[i] = nums1[nums1Index++];
                    } else if (nums1Index < nums1.length - 1 && nums2Index <= nums2.length - 1) {
                        if (nums1[nums1Index + 1] > nums2[nums2Index + 1]) {
                            ints[i] = nums1[nums1Index++];
                        } else {
                            ints[i] = nums2[nums2Index++];
                        }
                    }
                }
            }
            return ints;
        }


        private int[] merge(int[][] longer, int[][] shorter, int length) {
            /*
             * nums1的长度和nums2的长度和length的关系有很多种
             * longer.length, shorter.length, length
             * 3,3,3
             * 3,3,4
             * 3,3,2
             * 3,1,3
             * 5,3,4
             *
             */
            // max length array
            int min = Math.min(longer.length - 1, length);
            List<int[]> all = new ArrayList<>();
            // i代表longer这个数组出几个数
            for (int i = 0; i <= min; i++) {
                int sub = length - i;
                // 如果longer出i个数，但是剩下的数字无法从shorter从获得，则不计算
                if (sub <= shorter.length - 1) {
                    all.add(merge(longer[i], shorter[sub], length));
                }
            }
            return getMax(all);
        }

        private int[] getMax(List<int[]> all) {
            if (all.isEmpty()) {
                return new int[]{};
            }
            if (all.size() == 1) {
                return all.get(0);
            }
            int[] result = all.get(0);
            for (int i = 1; i < all.size(); i++) {
                int[] ints = all.get(i);
                if (ints.length > result.length) {
                    result = ints;
                }
                if (ints.length == result.length) {
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j] > result[j]) {
                            result = ints;
                            break;
                        } else if (ints[j] < result[j]) {
                            break;
                        }
                    }
                }
            }
            return result;
        }

        private int[] findMaxNumber(int[] nums1, int length) {
            if (length == nums1.length) {
                return nums1;
            }
            int[] ints = new int[length];
            int index = 0;
            int searchMinIndex = 0;
            while (index < ints.length) {
                int searchMaxIndex = nums1.length - (length - index);
                int currentMax = nums1[searchMinIndex];
                for (int i = searchMinIndex; i <= searchMaxIndex; i++) {
                    if (nums1[i] >= currentMax) {
                        currentMax = nums1[i];
                        searchMinIndex = i + 1;
                    }
                }
                ints[index++] = currentMax;
            }
            return ints;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}