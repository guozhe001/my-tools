package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * P40CombinationSumIiTest
 *
 * @author guozhe
 * @date 2020/09/09
 */
@Slf4j
public class P40CombinationSumIiTest {

    P40CombinationSumIi.Solution solution = new P40CombinationSumIi().new Solution();

    /**
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     */
    @Test
    public void case1() {
        List<List<Integer>> expectList = Lists.newArrayList(
                Lists.newArrayList(1, 7),
                Lists.newArrayList(1, 2, 5),
                Lists.newArrayList(2, 6),
                Lists.newArrayList(1, 1, 6));
        invokeCombinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8, expectList);
    }

    /**
     * 输入: candidates =[2,5,2,1,2], target =5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     */
    @Test
    public void case2() {
        List<List<Integer>> expectList = Lists.newArrayList(
                Lists.newArrayList(1, 2, 2),
                Lists.newArrayList(5));
        invokeCombinationSum2(new int[]{2, 5, 2, 1, 2}, 5, expectList);
    }

    /**
     * 调用方法
     *
     * @param candidates 给定数组
     * @param target     目标数字
     * @param expectList 期待的结果
     */
    private void invokeCombinationSum2(int[] candidates, int target, List<List<Integer>> expectList) {
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        log.info("candidates={}, target={}, result={}", candidates, target, lists);
        Assert.assertEquals(expectList.size(), lists.size());
    }


    @Test
    public void emptyListAdd() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.forEach(list -> log.info("{}", list));
        lists.forEach(list -> list.add(1));
        lists.forEach(list -> log.info("{}", list));
        Assert.assertTrue(lists.isEmpty());
    }

}