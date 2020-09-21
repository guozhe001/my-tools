//package com.nicai.algorithm.leetcode.editor.cn;
//
//import com.google.common.collect.Lists;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
///**
// * P40CombinationSumIiTest
// *
// * @author guozhe
// * @date 2020/09/09
// */
//@Slf4j
//public class P40CombinationSumIiTest {
//
//    P40CombinationSumIi.Solution solution = new P40CombinationSumIi().new Solution();
//
//    /**
//     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//     * 所求解集为:
//     * [
//     * [1, 7],
//     * [1, 2, 5],
//     * [2, 6],
//     * [1, 1, 6]
//     * ]
//     */
//    @Test
//    public void case1() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(1, 7),
//                Lists.newArrayList(1, 2, 5),
//                Lists.newArrayList(2, 6),
//                Lists.newArrayList(1, 1, 6));
//        invokeCombinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8, expectList);
//    }
//
//    /**
//     * 输入：candidates = [2,3,6,7], target = 7,
//     * 所求解集为：
//     * [
//     * [7],
//     * [2,2,3]
//     * ]
//     */
//    @Test
//    public void case2() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(7),
//                Lists.newArrayList(2, 2, 3));
//        invokeCombinationSum2(new int[]{2, 3, 6, 7}, 8, expectList);
//    }
//
//    /**
//     * 输入：candidates = [2,3,5], target = 8,
//     * 所求解集为：
//     * [
//     * [2,2,2,2],
//     * [2,3,3],
//     * [3,5]
//     * ]
//     */
//    @Test
//    public void case3() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(2, 2, 2, 2),
//                Lists.newArrayList(2, 3, 3),
//                Lists.newArrayList(3, 5));
//        invokeCombinationSum2(new int[]{2, 3, 5}, 8, expectList);
//    }
//
//    /**
//     * 输入：candidates = [1,2], target = 2,
//     * 所求解集为：
//     * [
//     * [1,1],
//     * [2]
//     * ]
//     */
//    @Test
//    public void case4() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(1, 1),
//                Lists.newArrayList(2));
//        invokeCombinationSum2(new int[]{1, 2}, 2, expectList);
//    }
//
//    /**
//     * 输入：candidates = [1,2], target = 4,
//     * 所求解集为：
//     * [
//     * [1,1,1,1],
//     * [1,1,2],
//     * [2,2]
//     * ]
//     */
//    @Test
//    public void case5() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(1, 1, 1, 1),
//                Lists.newArrayList(1, 1, 2),
//                Lists.newArrayList(2, 2));
//        invokeCombinationSum2(new int[]{1, 2}, 4, expectList);
//    }
//
//    /**
//     * 调用方法
//     *
//     * @param candidates 给定数组
//     * @param target     目标数字
//     * @param expectList 期待的结果
//     */
//    private void invokeCombinationSum2(int[] candidates, int target, List<List<Integer>> expectList) {
//        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
//        log.info("candidates={}, target={}, result={}", candidates, target, lists);
//        commonAssert(expectList, lists);
//    }
//
//    /**
//     * 断言
//     *
//     * @param expectList 期待结果
//     * @param actualList 真实结果
//     */
//    private void commonAssert(List<List<Integer>> expectList, List<List<Integer>> actualList) {
//        Assert.assertEquals(expectList.size(), actualList.size());
//    }
//}