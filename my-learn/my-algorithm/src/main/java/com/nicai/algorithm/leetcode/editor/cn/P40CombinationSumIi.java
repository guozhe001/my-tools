package com.nicai.algorithm.leetcode.editor.cn;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 350 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 II
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nicai
 */
public class P40CombinationSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param candidates 给定数组
         * @param target     目标数字
         * @return 所有数字只和为目标数字的列表
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            /*
            1、如果组合中有数字等于target，则这个数字是一个组合
            2、如果组合中有数字可以被target整除，则整除结果次的数字列表是一个组合
            3、如果组合中有多个数字只和等于target，则这些数字是一个组合
             */
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                int num = candidates[i];
                int newTarget = target - num;
                if (newTarget <= 0) {
                    if (newTarget == 0) {
                        result.add(getNewList(num));
                    }
                    continue;
                }

                // 查找剩下的数组中和为target-num的组合列表
                List<List<Integer>> lists = combinationSum2(candidates, newTarget);
                lists.forEach(list -> list.add(num));
                result.addAll(lists);
            }
            return result;
        }

        private List<Integer> getNewList(int... nums) {
            List<Integer> integers = new ArrayList<>();
            for (int num : nums) {
                integers.add(num);
            }
            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}