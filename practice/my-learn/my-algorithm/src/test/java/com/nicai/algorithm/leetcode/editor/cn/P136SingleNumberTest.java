package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P136SingleNumberTest
 *
 * @author guozhe
 * @date 2020/09/29
 */
public class P136SingleNumberTest {

    private P136SingleNumber.Solution solution = new P136SingleNumber().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: [2,2,1]
     * 输出: 1
     */
    @Test
    public void singleNumber() {
        Assert.assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    @Test
    public void singleNumber2() {
        Assert.assertEquals(4, solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

}