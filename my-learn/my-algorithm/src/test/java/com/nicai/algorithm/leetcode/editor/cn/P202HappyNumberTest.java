package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P202HappyNumberTest
 *
 * @author guozhe
 * @date 2020/10/19
 */
public class P202HappyNumberTest {

    private final P202HappyNumber.Solution solution = new P202HappyNumber().new Solution();

    @Test
    public void isHappy() {
        Assert.assertTrue(solution.isHappy(19));
    }

    @Test
    public void isHappy1() {
        Assert.assertTrue(solution.isHappy(28));
    }

    @Test
    public void isHappy3() {
        Assert.assertTrue(solution.isHappy(10));
    }

}