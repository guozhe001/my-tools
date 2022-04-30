package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P70ClimbingStairsTest
 *
 * @author guozhe
 * @date 2020/10/26
 */
public class P70ClimbingStairsTest {

    private final P70ClimbingStairs.Solution solution = new P70ClimbingStairs().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     */
    @Test
    public void climbStairs() {
        invokeAndAssert(2, 2);
    }

    /**
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    @Test
    public void climbStairs3() {
        invokeAndAssert(3, 3);
    }

    /**
     * 示例 3：
     * <p>
     * 输入： 4
     * 输出： 5
     * 解释：
     * 1.  1 阶 + 1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶 + 1 阶
     * 3.  1 阶 + 1 阶 + 2 阶
     * 4.  2 阶 + 1 阶 + 1 阶
     * 5.  2 阶 + 2 阶
     */
    @Test
    public void climbStairs1() {
        invokeAndAssert(4, 5);
    }

    private void invokeAndAssert(int input, int expect) {
        Assert.assertEquals(expect, solution.climbStairs(input));
    }

}