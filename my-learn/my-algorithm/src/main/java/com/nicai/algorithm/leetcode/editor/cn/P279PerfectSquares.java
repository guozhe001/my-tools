package com.nicai.algorithm.leetcode.editor.cn;
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
// 可能的完全平方组合：
// 9 + 1 + 1 + 1
// 4 + 4 + 4
// 4 + 4 + 1 + 1 + 1 + 1
// 其余不再列举
//输出: 3
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 636 👎 0

import java.util.*;

/**
 * 完全平方数
 *
 * @author nicai
 */
public class P279PerfectSquares {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // 有哪些完全平方数小于n
            Integer[] squares = initSquares(n).toArray(new Integer[]{});
            // 在完全平方数的数组中，有没有一个组合，使得组合的和等于n，如果这种组合存在，组合的数字最小的数字个数是多少
            return numSquares(n, squares);
        }

        /**
         * @param n           数字n
         * @param squareArray 完全平方数字数组
         * @return 完全平方数字
         */
        private int numSquares(int n, Integer[] squareArray) {
            // 动态规划
            Map<Integer, Integer> map = new HashMap<>(n);
            for (int j = squareArray.length - 1; j >= 0; j--) {
                int square = squareArray[j];
                for (int i = n; i >= 1; i--) {
                    if (i >= square) {
                        int num = i % square == 0 ? i / square : i / square + numSquares(i % square, squareArray);
                        Integer integer = map.get(i);
                        map.put(i, Objects.isNull(integer) ? num : Math.min(num, integer));
                    }
                }
            }
            return map.get(n);
        }

        /**
         * 初始化小于n的完全平方数的数字
         *
         * @param n 数字
         * @return 小于数字n的完全平方数列表
         */
        private List<Integer> initSquares(int n) {
            List<Integer> squares = new ArrayList<>();
            int i = 1;
            while (i <= n) {
                // 此处可能溢出 TODO
                int square = i * i;
                if (square <= n) {
                    squares.add(square);
                } else {
                    break;
                }
                i++;
            }
            return squares;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}