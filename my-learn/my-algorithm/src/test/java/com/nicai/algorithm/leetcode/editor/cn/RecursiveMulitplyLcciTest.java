package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * RecursiveMulitplyLcciTest
 *
 * @author guozhe
 * @date 2020/09/25
 */
public class RecursiveMulitplyLcciTest {

    private RecursiveMulitplyLcci.Solution solution = new RecursiveMulitplyLcci().new Solution();

    /**
     * 示例1:
     * <p>
     * 输入：A = 1, B = 10
     * 输出：10
     */
    @Test
    public void multiply1() {
        invokeAndAssert(1, 10, 10);
    }

    /**
     * 示例2:
     * <p>
     * 输入：A = 3, B = 4
     * 输出：12
     */
    @Test
    public void multiply2() {
        invokeAndAssert(3, 4, 12);
    }

    /**
     * 输入：A = 0, B = 4
     * 输出：0
     */
    @Test
    public void multiply3() {
        invokeAndAssert(0, 4, 0);
    }

    /**
     * 输入：A = 1, B = 4
     * 输出：4
     */
    @Test
    public void multiply4() {
        invokeAndAssert(1, 4, 4);
    }

    /**
     * 输入：A = 2, B = Integer.MAX_VALUE
     * 输出：exception
     */
    @Test
    public void multiply5() {
        Assert.assertThrows(IllegalArgumentException.class, () -> invokeAndAssert(2, Integer.MAX_VALUE, 4));
    }

    /**
     * 调用乘法方法并校验
     *
     * @param a      乘数a
     * @param b      乘数b
     * @param expect 期待的结果
     */
    private void invokeAndAssert(int a, int b, int expect) {
        Assert.assertEquals(expect, solution.multiply(a, b));
    }

}