package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P62UniquePathsTest {

    private final P62UniquePaths.Solution solution = new P62UniquePaths().new Solution();

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入：m = 3, n = 7
     * 输出：28
     */
    @Test
    public void uniquePaths() {
        invokeAndAssert(3, 7, 28);
    }

    /**
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     */
    @Test
    public void uniquePaths2() {
        invokeAndAssert(3, 2, 3);
    }

    /**
     * 示例 3：
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     */
    @Test
    public void uniquePaths3() {
        invokeAndAssert(7, 3, 28);
    }

    /**
     * 示例 4：
     * <p>
     * 输入：m = 3, n = 3
     * 输出：6
     */
    @Test
    public void uniquePaths4() {
        invokeAndAssert(3, 3, 6);
    }


    private void invokeAndAssert(int m, int n, int expect) {
        Assert.assertEquals(expect, solution.uniquePaths(m, n));
    }
}