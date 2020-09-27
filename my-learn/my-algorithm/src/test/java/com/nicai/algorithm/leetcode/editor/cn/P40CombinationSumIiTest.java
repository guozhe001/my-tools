//package com.nicai.algorithm.leetcode.editor.cn;
//
//import com.google.common.collect.Lists;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.powermock.reflect.Whitebox;
//
//import java.util.Arrays;
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
//     * 输入: candidates =[2,5,2,1,2], target =5,
//     * 所求解集为:
//     * [
//     * [1,2,2],
//     * [5]
//     * ]
//     */
//    @Test
//    public void case2() {
//        List<List<Integer>> expectList = Lists.newArrayList(
//                Lists.newArrayList(1, 2, 2),
//                Lists.newArrayList(5));
//        invokeCombinationSum2(new int[]{2, 5, 2, 1, 2}, 5, expectList);
//    }
//
//    @Test
//    public void getNewCandidatesIndex0() throws Exception {
//        invokeGetNewCandidatesAndAssert(new int[]{1, 2, 3, 4, 5}, 0);
//    }
//
//    @Test
//    public void getNewCandidatesIndex1() throws Exception {
//        invokeGetNewCandidatesAndAssert(new int[]{1, 2, 3, 4, 5}, 1);
//    }
//
//    @Test
//    public void getNewCandidatesIndex2() throws Exception {
//        invokeGetNewCandidatesAndAssert(new int[]{1, 2, 3, 4, 5}, 2);
//    }
//
//    @Test
//    public void getNewCandidatesIndex3() throws Exception {
//        invokeGetNewCandidatesAndAssert(new int[]{1, 2, 3, 4, 5}, 3);
//    }
//
//    @Test
//    public void addNumToAllList1() throws Exception {
//        invokeAddNumToAllList(3, getList(Lists.newArrayList(1, 2), Lists.newArrayList(1, 4, 5), Lists.newArrayList(2, 6, 5), Lists.newArrayList(2, 4, 6)));
//    }
//
//    private List<List<Integer>> getList(List<Integer>... lists) {
//        List<List<Integer>> result = Lists.newArrayList();
//        result.addAll(Arrays.asList(lists));
//        return result;
//    }
//
//    private void invokeAddNumToAllList(final int num, List<List<Integer>> list) throws Exception {
//        log.info("num={},oldList={}", num, list);
//        Whitebox.invokeMethod(solution, "addNumToAllList", num, list);
//        list.forEach(l -> Assert.assertTrue(l.contains(num)));
//        log.info("newList={}", list);
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
//
//    private void invokeGetNewCandidatesAndAssert(int[] candidates, int index) throws Exception {
//        int[] newCandidates = Whitebox.invokeMethod(solution, "getNewCandidatesAfterIndex", candidates, index);
//        Assert.assertEquals(candidates.length - index - 1, newCandidates.length);
//        log.info("newCandidates={}", newCandidates);
//        for (int i = 0; i < newCandidates.length; i++) {
//            Assert.assertEquals(candidates[i + index + 1], newCandidates[i]);
//        }
//    }
//}