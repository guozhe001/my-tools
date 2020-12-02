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

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

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

            return merge(dp1, dp2, k);
        }

        private int[][] dp(int[] nums1, int k) {
            int min = Math.min(nums1.length, k);
            int[][] dp = new int[min + 1][min];
            for (int i = 1; i <= min; i++) {
                dp[i] = findMaxNumber(nums1, i);
            }
            return dp;
        }

        private int[] toMaxNumberArray(List<UsedNumber> numbers) {
            List<UsedNumber> numbers1 = new ArrayList<>();
            List<UsedNumber> numbers2 = new ArrayList<>();
            for (UsedNumber usedNumber : numbers) {
                if (usedNumber.fromNums1) {
                    numbers1.add(usedNumber);
                } else {
                    numbers2.add(usedNumber);
                }
            }
            return merge(toArray(numbers1), toArray(numbers2), 1);
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

        private int[] merge(int[][] nums1, int[][] nums2, int length) {
            int[] ints = new int[length];
            // TODO 把这个实现了就完成了
            return ints;
        }

        private int[] toArray(List<UsedNumber> numbers) {
            int[] result = new int[numbers.size()];
            List<UsedNumber> collect = numbers.stream().sorted(Comparator.comparing(UsedNumber::getIndex)).collect(Collectors.toList());
            for (int j = 0; j < collect.size(); j++) {
                result[j] = collect.get(j).getValue();
            }
            return result;
        }


        private int findMaxNumber(int[] nums1, Set<UsedNumber> numbers, boolean fromNums1) {
            Set<Integer> collect = numbers.stream().filter(n -> n.fromNums1 == fromNums1).map(n -> n.index).collect(Collectors.toSet());
            int result = -1;
            if (collect.size() == nums1.length) {
                return result;
            }
            for (int i = 0; i < nums1.length; i++) {
                if (!collect.contains(i) && nums1[i] > result) {
                    result = i;
                }
            }
            return result;
        }


        private int[] findMaxNumber(int[] nums1, int length) {
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


        @Data
        public class UsedNumber {
            private int index;
            private int value;
            private boolean fromNums1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}