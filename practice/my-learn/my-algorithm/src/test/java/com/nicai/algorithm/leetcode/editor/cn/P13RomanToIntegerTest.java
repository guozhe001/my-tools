package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class P13RomanToIntegerTest {


    P13RomanToInteger.Solution solution = new P13RomanToInteger().new Solution();

    private void invoke(String param, int expect) {
        Assert.assertEquals(expect, solution.romanToInt(param));
    }

    /**
     * //
     * // 示例 1:
     * //
     * //
     * //输入: s = "III"
     * //输出: 3
     */
    @Test
    public void case1() {
        invoke("III", 3);
    }


    /**
     * // 示例 2:
     * //
     * //
     * //输入: s = "IV"
     * //输出: 4
     */
    @Test
    public void case2() {
        invoke("IV", 4);
    }

    /**
     * // 示例 3:
     * //
     * //
     * //输入: s = "IX"
     * //输出: 9
     */
    @Test
    public void case3() {
        invoke("IX", 9);
    }


    /**
     * // 示例 4:
     * //
     * //
     * //输入: s = "LVIII"
     * //输出: 58
     * //解释: L = 50, V= 5, III = 3.
     * //
     */
    @Test
    public void case4() {
        invoke("LVIII", 58);
    }

    /**
     * // 示例 5:
     * //
     * //
     * //输入: s = "MCMXCIV"
     * //输出: 1994
     * //解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * //
     */
    @Test
    public void case5() {
        invoke("MCMXCIV", 1994);
    }


}