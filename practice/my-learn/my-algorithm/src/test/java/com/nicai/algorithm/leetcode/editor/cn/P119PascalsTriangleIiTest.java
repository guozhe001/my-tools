package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class P119PascalsTriangleIiTest {

    private final P119PascalsTriangleIi.Solution solution = new P119PascalsTriangleIi().new Solution();

    /**
     * // 示例 1:
     * //
     * //
     * //输入: rowIndex = 3
     * //输出: [1,3,3,1]
     */
    @Test
    public void arraySign() {
        invokeAndAssert(3, Lists.newArrayList(1,3,3,1));
    }


    /**
     * // 示例 2:
     * //
     * //
     * //输入: rowIndex = 0
     * //输出: [1]
     */
    @Test
    public void arraySign2() {
        invokeAndAssert(0, Lists.newArrayList(1));
    }

    /**
     * // 示例 3:
     * //
     * //
     * //输入: rowIndex = 1
     * //输出: [1,1]
     */
    @Test
    public void arraySign3() {
        invokeAndAssert(1, Lists.newArrayList(1, 1));
    }

    private void invokeAndAssert(int input, List<Integer> expect) {
        Assert.assertEquals(expect, solution.getRow(input));
    }


}