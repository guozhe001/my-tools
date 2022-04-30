package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P168ExcelSheetColumnTitleTest
 *
 * @author guozhe
 * @date 2020/10/14
 */
public class P168ExcelSheetColumnTitleTest {

    public P168ExcelSheetColumnTitle.Solution solution = new P168ExcelSheetColumnTitle().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "A"
     */
    @Test
    public void convertToTitle() {
        Assert.assertEquals("A", solution.convertToTitle(1));
    }

    /**
     * 示例 2:
     * <p>
     * 输入: 28
     * 输出: "AB"
     */
    @Test
    public void convertToTitle1() {
        Assert.assertEquals("AB", solution.convertToTitle(28));
    }

    /**
     * 示例 3:
     * <p>
     * 输入: 701
     * 输出: "ZY"
     */
    @Test
    public void convertToTitle2() {
        Assert.assertEquals("ZY", solution.convertToTitle(701));
    }

    /**
     * 示例 4:
     * <p>
     * 输入: 52
     * 输出: "AZ"
     * <p>
     */
    @Test
    public void convertToTitle3() {
        Assert.assertEquals("AZ", solution.convertToTitle(52));
    }
}