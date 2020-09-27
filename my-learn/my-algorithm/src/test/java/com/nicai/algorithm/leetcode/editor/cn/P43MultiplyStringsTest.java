package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * P43MultiplyStringsTest
 *
 * @author guozhe
 * @date 2020/09/27
 */
@Slf4j
public class P43MultiplyStringsTest {

    private P43MultiplyStrings.Solution solution = new P43MultiplyStrings().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     */
    @Test
    public void multiply() {
        invokeAndAssert("2", "3", "6");
    }

    /**
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     */
    @Test
    public void multiply2() {
        invokeAndAssert("123", "456", "56088");
    }

    /**
     * 示例 3:
     * <p>
     * 输入: num1 = "2147483647", num2 = "2"
     * 输出: "4294967294"
     */
    @Test
    public void multiply3() {
        log.info("Integer.MAX_VALUE={}, Integer.MAX_VALUE * 2 = {}", Integer.MAX_VALUE, Integer.MAX_VALUE * 2L);
        invokeAndAssert("2147483647", "2", "4294967294");
    }

    private void invokeAndAssert(String num1, String num2, String expect) {
        Assert.assertEquals(expect, solution.multiply(num1, num2));
    }

}