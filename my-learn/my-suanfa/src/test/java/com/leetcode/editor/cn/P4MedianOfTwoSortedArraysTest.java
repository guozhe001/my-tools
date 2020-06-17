package com.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * @author guozhe
 * @date 2020/6/17
 */
@Slf4j
public class P4MedianOfTwoSortedArraysTest {

    P4MedianOfTwoSortedArrays.Solution solution = new P4MedianOfTwoSortedArrays().new Solution();

    private static final int[] NUMS1 = new int[]{1, 2, 3, 4, 5, 6};
    private static final int[] NUMS2 = new int[]{1, 2, 3, 4, 5, 6, 7};

    @Test
    public void getMidNums() throws Exception {
        int[] midNums = Whitebox.invokeMethod(solution, "getMidNums", NUMS1);
        Assert.assertEquals(2, midNums.length);
        Assert.assertEquals(3, midNums[0]);
        Assert.assertEquals(4, midNums[1]);
    }

    @Test
    public void getMidNums0() throws Exception {
        int[] midNums = Whitebox.invokeMethod(solution, "getMidNums", NUMS2);
        Assert.assertEquals(1, midNums.length);
        Assert.assertEquals(4, midNums[0]);
    }

    @Test
    public void wei() {
        log.info("位运算 4/2 = 4>>1 = {}", 4 >> 1);
        log.info("算数运算 4/2 = {}", 4 / 2);
    }

}