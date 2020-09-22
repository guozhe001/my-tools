package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Z字形变换单测
 *
 * @author guozhe
 * @date 2020/09/21
 */
@Slf4j
public class P6ZigzagConversionTest {

    /**
     * 解决方法
     */
    private final P6ZigzagConversion.Solution solution = new P6ZigzagConversion().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 输出: "LCIRETOESIIGEDHN"
     */
    @Test
    public void convert() {
        invokeAndAssert("LEETCODEISHIRING", 3, "LCIRETOESIIGEDHN");
    }

    /**
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * 输出: "LDREOEIIECIHNTSG"
     */
    @Test
    public void convert2() {
        invokeAndAssert("LEETCODEISHIRING", 4, "LDREOEIIECIHNTSG");
    }

    /**
     * 示例 3:
     * <p>
     * 输入: s = "AB", numRows = 1
     * 输出: "AB"
     */
    @Test
    public void convert3() {
        invokeAndAssert("AB", 1, "AB");
    }

    /**
     * 示例 4:
     *
     * <p>
     * 输入: s = "PAYPALISHIRING", numRows = 4
     * 输出: "PINALSIGYAHRPI"
     */
    @Test
    public void convert4() {
        invokeAndAssert("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
    }

    /**
     * 调用并且校验
     *
     * @param input   输入
     * @param numRows 行数
     * @param expect  期待的结果
     */
    private void invokeAndAssert(String input, int numRows, String expect) {
        log.info("input={}, numRows={}, expect={}", input, numRows, expect);
        String convert = solution.convert(input, numRows);
        Assert.assertEquals(expect, convert);
    }

}