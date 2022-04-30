package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.List;
import java.util.Stack;

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
     * 输入: num1 = "99999", num2 = "0"
     * 输出: "0"
     */
    @Test
    public void multiply3() {
        invokeAndAssert("99999", "0", "0");
    }

    /**
     * 示例 4:
     * <p>
     * 输入: num1 = "2147483647", num2 = "2"
     * 输出: "4294967294"
     */
    @Test
    public void multiply4() {
        log.info("Integer.MAX_VALUE={}, Integer.MAX_VALUE * 2 = {}", Integer.MAX_VALUE, Integer.MAX_VALUE * 2L);
        invokeAndAssert("2147483647", "2", "4294967294");
    }

    /**
     * 示例 5:
     * <p>
     * 输入: num1 = "123456789", num2 = "2147483647"
     * 输出: "265121435488629483"
     */
    @Test
    public void multiply5() {
        log.info("Integer.MAX_VALUE={}, Integer.MAX_VALUE * 2 = {}", Integer.MAX_VALUE, Integer.MAX_VALUE * 2L);
        invokeAndAssert("123456789", "2147483647", "265121435488629483");
    }

    private void invokeAndAssert(String num1, String num2, String expect) {
        Assert.assertEquals(expect, solution.multiply(num1, num2));
    }

    @Test
    public void getIntArray() throws Exception {
        int[] result = Whitebox.invokeMethod(solution, "getIntArray", "12328374");
        int[] expect = new int[]{1, 2, 3, 2, 8, 3, 7, 4};
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], result[i]);
        }
    }

    @Test
    public void multiplyIntArray() throws Exception {
        List<String> strings = Whitebox.invokeMethod(solution, "multiply", new int[]{1, 2, 8}, new int[]{2, 4, 6});
        Assert.assertEquals(3, strings.size());
        Assert.assertTrue((strings.contains("768") && strings.contains("5120") && strings.contains("25600"))
                || (strings.contains("1968") && strings.contains("4920") && strings.contains("24600")));
    }

    @Test
    public void addIntArray() throws Exception {
        String str = Whitebox.invokeMethod(solution, "add", new int[]{1, 2, 8}, new int[]{2, 4, 6});
        Assert.assertEquals("374", str);
    }

    @Test
    public void addAllString() throws Exception {
        String str = Whitebox.invokeMethod(solution, "addAllString", Lists.newArrayList("123", "321", "1000"));
        Assert.assertEquals("1444", str);
    }

    @Test
    public void stringToStack() throws Exception {
        Stack<Integer> stack = Whitebox.invokeMethod(solution, "stringToStack", "12323278");
        int[] ints = new int[]{8, 7, 2, 3, 2, 3, 2, 1};
        for (int i = 0; i < ints.length; i++) {
            Assert.assertEquals(Integer.valueOf(ints[i]), stack.pop());
        }
    }

}