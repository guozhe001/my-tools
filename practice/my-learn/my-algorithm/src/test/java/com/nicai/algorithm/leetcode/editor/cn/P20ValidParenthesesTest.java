package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P20ValidParenthesesTest {
    P20ValidParentheses.Solution solution = new P20ValidParentheses().new Solution();


    @Test
    public void isValid_case1() {
        invokeAndAssert("()", true);
    }


    @Test
    public void isValid_case2() {
        invokeAndAssert("()[]{}", true);
    }


    @Test
    public void isValid_case3() {
        invokeAndAssert("(]", false);
    }

    private void invokeAndAssert(String param, boolean expect) {
        Assert.assertEquals(expect, solution.isValid(param));
    }

}