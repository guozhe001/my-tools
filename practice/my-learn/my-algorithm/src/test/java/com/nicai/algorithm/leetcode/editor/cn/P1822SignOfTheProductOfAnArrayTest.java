package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P1822SignOfTheProductOfAnArrayTest {


    private final P1822SignOfTheProductOfAnArray.Solution solution = new P1822SignOfTheProductOfAnArray().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入：nums = [-1,-2,-3,-4,3,2,1]
     * 输出：1
     * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
     */
    @Test
    public void arraySign() {
        invokeAndAssert(new int[]{-1, -2, -3, -4, 3, 2, 1}, 1);
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
        invokeAndAssert(new int[]{1, 5, 0, 2, -3}, 0);
    }

    /**
     * 示例 3：
     * //
     * //
     * //输入：nums = [-1,1,-1,1,-1]
     * //输出：-1
     * //解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
     */
    @Test
    public void arraySign3() {
        invokeAndAssert(new int[]{-1, 1, -1, 1, -1}, -1);
    }


    private void invokeAndAssert(int[] numbers, int expect) {
        Assert.assertEquals(expect, solution.arraySign(numbers));
    }

}