package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * P233NumberOfDigitOneTest
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class P233NumberOfDigitOneTest {

    private P233NumberOfDigitOne.Solution solution = new P233NumberOfDigitOne().new Solution();

    @Test
    public void countDigitOne() {
        Assert.assertEquals(6, solution.countDigitOne(13));
    }

    @Test
    public void countDigitOne1() {
        Assert.assertEquals(0, solution.countDigitOne(-1));
    }

//    @Test
//    public void countDigitOne2() {
//        Assert.assertEquals(2978524, solution.countDigitOne(3184191));
//    }
//
//    @Test
//    public void countDigitOne3() {
//        Assert.assertEquals(767944060, solution.countDigitOne(824883294));
//    }

    @Test
    public void countDigitOne4() {
        Assert.assertEquals(12, solution.countDigitOne(19));
    }

    @Test
    public void countDigitOne5() {
        Assert.assertEquals(12, solution.countDigitOne(20));
    }

    @Test
    public void countDigitOne6() {
        Assert.assertEquals(13, solution.countDigitOne(21));
    }

    @Test
    public void countDigitOne7() {
        Assert.assertEquals(14, solution.countDigitOne(31));
    }

    @Test
    public void countDigitOne8() {
        Assert.assertEquals(15, solution.countDigitOne(41));
    }

    @Test
    public void countDigitOne9() {
        Assert.assertEquals(16, solution.countDigitOne(59));
    }

    @Test
    public void countDigitOne10() {
        Assert.assertEquals(17, solution.countDigitOne(68));
    }

    @Test
    public void countDigitOne11() {
        Assert.assertEquals(18, solution.countDigitOne(78));
    }

    @Test
    public void countDigitOne12() {
        Assert.assertEquals(19, solution.countDigitOne(88));
    }

    @Test
    public void countDigitOne13() {
        Assert.assertEquals(20, solution.countDigitOne(99));
    }

    @Test
    public void countDigitOneString() throws Exception {
        int countDigitOne = Whitebox.invokeMethod(solution, "countDigitOne", "3184191");
        Assert.assertEquals(3, countDigitOne);
    }

}