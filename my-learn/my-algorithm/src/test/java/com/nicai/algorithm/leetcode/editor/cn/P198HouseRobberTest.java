package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P198HouseRobberTest
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class P198HouseRobberTest {

    public P198HouseRobber.Solution solution = new P198HouseRobber().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     */
    @Test
    public void rob() {
        invokeAndAssert(new int[]{1, 2, 3, 1}, 4);
    }

    /**
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */
    @Test
    public void rob1() {
        invokeAndAssert(new int[]{2, 7, 9, 3, 1}, 12);
    }

    /**
     * @param input  入参
     * @param expect 期待的结果
     */
    private void invokeAndAssert(int[] input, int expect) {
        Assert.assertEquals(expect, solution.rob(input));
        Assert.assertEquals(expect, solution.robRecursion(input));
    }

}