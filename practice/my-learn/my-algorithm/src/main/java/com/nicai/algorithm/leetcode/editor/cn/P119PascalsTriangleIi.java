package com.nicai.algorithm.leetcode.editor.cn;
//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 438 👎 0

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class P119PascalsTriangleIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> result = new ArrayList<>();
            int i = 1;
            while (i <= rowIndex + 1) {
                if (i == 1) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(1);
                    result.add(integers);
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    List<Integer> integers1 = result.get(i - 2);
                    for (int j = 0; j < i; j++) {
                        if (j == 0) {
                            integers.add(j, integers1.get(j));
                        } else if (j == i - 1) {
                            integers.add(j, integers1.get(j - 1));
                        } else {
                            integers.add(j, integers1.get(j - 1) + integers1.get(j));
                        }
                    }
                    result.add(integers);
                }
                i++;
            }
            return result.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}