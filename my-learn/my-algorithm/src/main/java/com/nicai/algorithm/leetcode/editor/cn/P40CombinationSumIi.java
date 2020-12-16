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
import java.util.Arrays;
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
         * @return 所有数字之和为目标数字的列表
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            return combinationSum2(candidates, target, 0);
        }
        // TODO
        public List<List<Integer>> combinationSum2(int[] candidates, int target, int startIndex) {
            List<List<Integer>> result = new ArrayList<>();
            if (startIndex == candidates.length) {
                return result;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                int num = candidates[i];
                if (num == target) {
                    result.add(Arrays.asList(num));
                } else {
                    int newTarget = target - num;
                    if (newTarget > 0) {
                        List<List<Integer>> lists = combinationSum2(candidates, newTarget, i + 1);
                        for (List<Integer> list : lists) {
                            list.add(num);
                        }
                        result = lists;
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}