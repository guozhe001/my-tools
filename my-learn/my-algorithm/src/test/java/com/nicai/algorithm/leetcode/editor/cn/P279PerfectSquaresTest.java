package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P279PerfectSquaresTest
 *
 * @author guozhe
 * @date 2020/10/19
 */
public class P279PerfectSquaresTest {

    private P279PerfectSquares.Solution solution = new P279PerfectSquares().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     */
    @Test
    public void numSquares() {
        Assert.assertEquals(3, solution.numSquares(12));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */
    @Test
    public void numSquares1() {
        Assert.assertEquals(2, solution.numSquares(13));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: n = 200
     * 输出: 2
     * 解释: 200 = 100 + 100.
     */
    @Test
    public void numSquares2() {
        Assert.assertEquals(2, solution.numSquares(200));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: n = 199
     * 输出: 4
     * 解释: 199 = 81 + 81 + 36 + 1.
     */
    @Test
    public void numSquares3() {
        Assert.assertEquals(4, solution.numSquares(199));
    }
}