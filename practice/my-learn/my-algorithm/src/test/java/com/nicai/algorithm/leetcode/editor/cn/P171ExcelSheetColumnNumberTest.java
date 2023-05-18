package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P171ExcelSheetColumnNumberTest {

    P171ExcelSheetColumnNumber.Solution solution = new P171ExcelSheetColumnNumber().new Solution();

    @Test
    void testTitleToNumber() {
        int result = solution.titleToNumber("A");
        Assertions.assertEquals(1, result);
    }

    @Test
    void testTitleToNumber1() {
        int result = solution.titleToNumber("AB");
        Assertions.assertEquals(28, result);
    }

    @Test
    void testTitleToNumber3() {
        int result = solution.titleToNumber("ZY");
        Assertions.assertEquals(701, result);
    }

}
