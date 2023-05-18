package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    P15ThreeSum.Solution solution = new P15ThreeSum().new Solution();

    /**
     * //输入：nums = [-1,0,1,2,-1,-4]
     * //输出：[[-1,-1,2],[-1,0,1]]
     */
    @Test
    void testThreeSum() {
        invokeAndAssert(new int[]{-1, 0, 1, 2, -1, -4}, Lists.newArrayList(Lists.newArrayList(-1, -1, 2), Lists.newArrayList(-1, 0, 1)));
    }

    /**
     * 输入：nums = [0,1,1]
     * //输出：[]
     */
    @Test
    void testThreeSum_2() {
        invokeAndAssert(new int[]{0, 1, 1}, Lists.newArrayList());
    }

    /**
     * //输入：nums = [0,0,0]
     * //输出：[[0,0,0]]
     * //解释：唯一可能的三元组和为 0 。
     */
    @Test
    void testThreeSum_3() {
        List<Integer> integers = Lists.newArrayList(0, 0, 0);
        List<List<Integer>> objects = new ArrayList<>();
        objects.add(integers);
        invokeAndAssert(new int[]{0, 0, 0}, objects);
    }

    private void invokeAndAssert(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSum(input);
        Assertions.assertEquals(expected, result);
    }

}

