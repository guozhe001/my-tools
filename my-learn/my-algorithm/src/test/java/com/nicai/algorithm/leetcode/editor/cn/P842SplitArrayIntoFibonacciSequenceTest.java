package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.List;

@Slf4j
public class P842SplitArrayIntoFibonacciSequenceTest {

    private final P842SplitArrayIntoFibonacciSequence.Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();


    /**
     * 示例 1：
     * <p>
     * 输入："123456579"
     * 输出：[123,456,579]
     */
    @Test
    public void splitIntoFibonacci() {
        invokeAndSAssert("123456579", ImmutableList.of(123, 456, 579));
    }


    /**
     * 示例 2：
     * <p>
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     */
    @Test
    public void splitIntoFibonacci2() {
        invokeAndSAssert("11235813", ImmutableList.of(1, 1, 2, 3, 5, 8, 13));
    }

    /**
     * 示例 3：
     * <p>
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     */
    @Test
    public void splitIntoFibonacci3() {
        invokeAndSAssert("112358130", ImmutableList.of());
    }


    /**
     * 示例 4：
     * <p>
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     */
    @Test
    public void splitIntoFibonacci4() {
        invokeAndSAssert("0123", ImmutableList.of());
    }

    /**
     * 示例 5：
     * <p>
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     */
    @Test
    public void splitIntoFibonacci5() {
        try {
            invokeAndSAssert("1101111", ImmutableList.of(110, 1, 111));
        } catch (AssertionError assertionError) {
            invokeAndSAssert("1101111", ImmutableList.of(11, 0, 11, 11));
        }

    }

    @Test
    public void testArrayCopyOf() throws Exception {
        String s = "1101111";
        // 因为类型不一致的原因会抛java.lang.ArrayStoreException
        // int[] ints = new int[s.length()];
        // System.arraycopy(s.toCharArray(), 0, ints, 0, s.length());
        int[] numbers = Whitebox.invokeMethod(solution, "toIntArray", s);
        Assert.assertArrayEquals(new int[]{1, 1, 0, 1, 1, 1, 1}, numbers);
    }

    @Test
    public void testArrayCopyOf2() throws Exception {
        String s = "112358130";
        // 因为类型不一致的原因会抛java.lang.ArrayStoreException
        // int[] ints = new int[s.length()];
        // System.arraycopy(s.toCharArray(), 0, ints, 0, s.length());
        int[] numbers = Whitebox.invokeMethod(solution, "toIntArray", s);
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 1, 3, 0}, numbers);
    }

    private void invokeAndSAssert(String input, List<Integer> expect) {
        List<Integer> result = solution.splitIntoFibonacci(input);
        Assert.assertEquals(expect.size(), result.size());
        Assert.assertEquals(expect, result);
    }
}