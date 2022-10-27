package com.nicai.algorithm.leetcode.editor.cn;


import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangleTest {

    private final P118PascalsTriangle.Solution solution = new P118PascalsTriangle().new Solution();

    /**
     * //
     * // 示例 1:
     * //
     * //
     * //输入: numRows = 5
     * //输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * //
     */
    @Test
    public void arraySign() {
        invokeAndAssert(5, Lists.newArrayList(
                Lists.newArrayList(1),
                Lists.newArrayList(1, 1),
                Lists.newArrayList(1, 2, 1),
                Lists.newArrayList(1, 3, 3, 1),
                Lists.newArrayList(1, 4, 6, 4, 1)));
    }


    /**
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,5,0,2,-3]
     * //输出：0
     * //解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
     */
    @Test
    public void arraySign2() {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        objects.add(integers);
        invokeAndAssert(1, objects);
    }

    private void invokeAndAssert(int input, List<List<Integer>> expect) {
        Assert.assertEquals(expect, solution.generate(input));
    }

}