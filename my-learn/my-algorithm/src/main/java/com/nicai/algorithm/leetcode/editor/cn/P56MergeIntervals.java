package com.nicai.algorithm.leetcode.editor.cn;
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 629 👎 0

import java.util.*;

/**
 * 合并区间
 *
 * @author nicai
 */
public class P56MergeIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Set<int[]> integers = new HashSet<>();
            Set<int[]> resultSet = new HashSet<>();
            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                for (int j = i + 1; j < intervals.length; j++) {
                    int[] intervali = intervals[j];
                    /*
                     * 枚举哪些需要合并：
                     * [1,2],[3,5] false
                     * [1,3],[3,5] true ->[1,5]
                     * [1,4],[3,5] true ->[1,5]
                     * [1,4],[3,5] true ->[1,5]
                     * [1,5],[3,5] true ->[1,5]
                     * [1,6],[3,5] true ->[1,6]
                     * [1,7],[3,5] true ->[1,7]
                     * [2,7],[3,5] true ->[2,7]
                     * [3,7],[3,5] true ->[3,7]
                     * [4,7],[3,5] true ->[3,7]
                     * [5,7],[3,5] true ->[3,7]
                     * [6,7],[3,5] false
                     */
                    if (!(interval[1] < intervali[0]) && !(interval[0] > intervali[1])) {
                        int[] merge = merge(interval, intervali);
                        interval[0] = merge[0];
                        interval[1] = merge[merge.length - 1];
                        integers.add(intervali);
                        resultSet.add(interval);
                    }
                }
            }
            int[][] result = new int[intervals.length - integers.size()][];
            int i = 0;
            for (int[] ints : intervals) {
                if (!integers.contains(ints)) {
                    result[i] = ints;
                    i++;
                }
            }
            return Arrays.equals(result, intervals) ? intervals : merge(result);
        }

        /**
         * 合并两个数组，新数组包含两个数组的所有元素，并且按照从小到大排列
         *
         * @param interval1 数组1
         * @param interval2 数组2
         * @return 合并后的包含入参的所有元素的新数组
         */
        private int[] merge(int[] interval1, int[] interval2) {
            int[] ints = new int[interval1.length + interval2.length];
            System.arraycopy(interval1, 0, ints, 0, interval1.length);
            System.arraycopy(interval2, 0, ints, interval1.length, interval2.length);
            return sort(ints);
        }

        /**
         * 对数组进行排序
         *
         * @param ints 数组
         * @return 排好序的数组
         */
        private int[] sort(int[] ints) {
            if (ints.length <= 1) {
                return ints;
            }
            int a = ints[0];
            List<Integer> smallNumList = new ArrayList<>();
            List<Integer> bigNumList = new ArrayList<>();
            for (int i = 1; i < ints.length; i++) {
                int anInt = ints[i];
                if (anInt <= a) {
                    smallNumList.add(anInt);
                } else {
                    bigNumList.add(anInt);
                }
            }
            return merge(sort(listToArray(smallNumList)), a, sort(listToArray(bigNumList)));
        }

        private int[] listToArray(List<Integer> list) {
            int[] ints = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = list.get(i);
            }
            return ints;
        }

        private int[] merge(int[] smallNum, int a, int[] bigNum) {
            int[] ints = new int[smallNum.length + 1 + bigNum.length];
            System.arraycopy(smallNum, 0, ints, 0, smallNum.length);
            ints[smallNum.length] = a;
            System.arraycopy(bigNum, 0, ints, smallNum.length + 1, bigNum.length);
            return ints;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}