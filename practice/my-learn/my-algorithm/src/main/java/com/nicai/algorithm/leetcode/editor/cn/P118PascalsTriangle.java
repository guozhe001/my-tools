package com.nicai.algorithm.leetcode.editor.cn;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 860 👎 0

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            int i = 1;
            while (i <= numRows) {
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
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}