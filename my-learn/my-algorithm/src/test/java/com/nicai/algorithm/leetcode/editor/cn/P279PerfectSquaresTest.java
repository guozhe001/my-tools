package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * P279PerfectSquaresTest
 *
 * @author guozhe
 * @date 2020/10/19
 */
@Slf4j
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

    /**
     * 示例 5:
     * <p>
     * 输入: n = 209
     * 输出: 3
     * 解释: 199 = 100 + 100 + 9.
     */
    @Test
    public void numSquares4() {
        Assert.assertEquals(3, solution.numSquares(209));
    }

    /**
     * 示例 6:
     * <p>
     * 输入: n = 210
     * 输出: 4
     * 解释: 199 = 100 + 100 + 9 + 1.
     */
    @Test
    public void numSquares5() {
        Assert.assertEquals(3, solution.numSquares(209));
    }

    /**
     * 示例 7:
     * <p>
     * 输入: n = 260
     * 输出: 2
     * 解释: 260 = 256 + 4.
     */
    @Test
    public void numSquares6() {
        Assert.assertEquals(2, solution.numSquares(260));
    }

    /**
     * 示例 8:
     * <p>
     * 输入: n = 257
     * 输出: 2
     * 解释: 257 = 256 + 1.
     */
    @Test
    public void numSquares7() {
        Assert.assertEquals(2, solution.numSquares(257));
    }

    /**
     * 示例 9:
     * <p>
     * 输入: n = 258
     * 输出: 3
     * 解释: 258 = 256 + 1 + 1.
     */
    @Test
    public void numSquares8() {
        Assert.assertEquals(3, solution.numSquares(258));
    }

    /**
     * 示例 10:
     * <p>
     * 输入: n = 247
     * 输出: 3
     * 解释: 247 = 256 + 1 + 1.
     */
    @Test
    public void numSquares9() {
        Assert.assertEquals(4, solution.numSquares(247));
    }

    @Test
    public void initSquares() throws Exception {
        int[] squares = Whitebox.invokeMethod(solution, "initSquares", 20);
        Assert.assertArrayEquals(new int[]{1, 4, 9, 16}, squares);
        log.info("squares={}", squares);
    }


    @Test
    public void initSquares1() throws Exception {
        int[] squares = Whitebox.invokeMethod(solution, "initSquares", 26);
        Assert.assertArrayEquals(new int[]{1, 4, 9, 16, 25}, squares);
        log.info("squares={}", squares);
    }


}