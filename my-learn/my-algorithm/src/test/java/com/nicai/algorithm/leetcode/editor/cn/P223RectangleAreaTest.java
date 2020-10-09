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
     * 示例:
     * <p>
     * 输入: -3, 0, 3, 4, 0, -1, 9, 2
     * 输出: 45
     */
    @Test
    public void computeArea() {
        Assert.assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    /**
     * 示例:
     * <p>
     * 输入: -2, -2, 2, 2, 3, 3, 4, 4
     * 输出: 17
     */
    @Test
    public void computeArea2() {
        Assert.assertEquals(17, solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

}