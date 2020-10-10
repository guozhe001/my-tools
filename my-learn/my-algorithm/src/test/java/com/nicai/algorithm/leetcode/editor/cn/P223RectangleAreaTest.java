package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P223RectangleAreaTest
 *
 * @author guozhe
 * @date 2020/10/09
 */
public class P223RectangleAreaTest {

    private P223RectangleArea.Solution solution = new P223RectangleArea().new Solution();

    /**
     * 示例:重叠部分
     * <p>
     * 输入: -3, 0, 3, 4, 0, -1, 9, 2
     * 输出: 45
     */
    @Test
    public void computeArea() {
        Assert.assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    /**
     * 示例:没有重叠，X在Y的左下（第一个矩形为X，第二个矩形为Y）
     * <p>
     * 输入: -2, -2, 2, 2, 3, 3, 4, 4
     * 输出: 17
     */
    @Test
    public void computeArea2() {
        Assert.assertEquals(17, solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    /**
     * 示例:没有重叠，X在Y的右下（第一个矩形为X，第二个矩形为Y）
     * <p>
     * 输入: -2, -2, 2, 2, -4, 3, -3, 4
     * 输出: 17
     */
    @Test
    public void computeArea3() {
        Assert.assertEquals(17, solution.computeArea(-2, -2, 2, 2, -4, 3, -3, 4));
    }

    /**
     * 示例:没有重叠，X在Y的右上（第一个矩形为X，第二个矩形为Y）
     * <p>
     * 输入: -2, -2, 2, 2, -4, -4, -3, -3
     * 输出: 17
     */
    @Test
    public void computeArea4() {
        Assert.assertEquals(17, solution.computeArea(-2, -2, 2, 2, -4, -4, -3, -3));
    }

    /**
     * 示例:没有重叠，X在Y的左上（第一个矩形为X，第二个矩形为Y）
     * <p>
     * 输入: -2, -2, 2, 2, 3, -4, 4, -3
     * 输出: 17
     */
    @Test
    public void computeArea5() {
        Assert.assertEquals(17, solution.computeArea(-2, -2, 2, 2, 3, -4, 4, -3));
    }

    /**
     * 示例:完全重叠
     * <p>
     * 输入: -2, -2, 2, 2, -2, -2, 2, 2
     * 输出: 16
     */
    @Test
    public void computeArea6() {
        Assert.assertEquals(16, solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    /**
     * 示例:X在Y的正下方
     * <p>
     * 输入: -2 -4 2 -2 -2 -2 2 2
     * 输出: 24
     */
    @Test
    public void computeArea7() {
        Assert.assertEquals(24, solution.computeArea(-2, -4, 2, -2, -2, -2, 2, 2));
    }

    /**
     * 示例
     * <p>
     * 输入: -2286 -1386 -2279 -1380 -2284 -1384 -2273 -1375
     * 输出: 121
     */
    @Test
    public void computeArea8() {
        Assert.assertEquals(121, solution.computeArea(-2286, -1386, -2279, -1380, -2284, -1384, -2273, -1375));
    }

}