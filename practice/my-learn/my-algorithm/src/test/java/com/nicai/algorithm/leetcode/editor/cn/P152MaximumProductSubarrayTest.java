package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P152MaximumProductSubarrayTest
 *
 * @author guozhe
 * @date 2020/10/20
 */
public class P152MaximumProductSubarrayTest {

    private final P152MaximumProductSubarray.Solution solution = new P152MaximumProductSubarray().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     */
    @Test
    public void maxProduct() {
        Assert.assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    @Test
    public void maxProduct1() {
        Assert.assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: [-2]
     * 输出: -2
     */
    @Test
    public void maxProduct2() {
        Assert.assertEquals(-2, solution.maxProduct(new int[]{-2}));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: [0, 2]
     * 输出: 0
     */
    @Test
    public void maxProduct3() {
        Assert.assertEquals(2, solution.maxProduct(new int[]{0, 2}));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: [-2,3,-4]
     * 输出: 24
     */
    @Test
    public void maxProduct4() {
        Assert.assertEquals(24, solution.maxProduct(new int[]{-2, 3, -4}));
    }

}