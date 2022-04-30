package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * P56MergeIntervalsTest
 *
 * @author guozhe
 * @date 2020/09/28
 */
@Slf4j
public class P56MergeIntervalsTest {

    private P56MergeIntervals.Solution solution = new P56MergeIntervals().new Solution();

    /**
     * 示例 1:
     * <p>
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    @Test
    public void merge() {
        invokeAndAssert(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}});
    }

    /**
     * 示例 2:
     * <p>
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    @Test
    public void merge2() {
        invokeAndAssert(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}});
    }

    /**
     * 输入: intervals = [[0,4],[1,4]]
     * 输出: [[0,4]]
     */
    @Test
    public void merge3() {
        invokeAndAssert(new int[][]{{1, 4}, {0, 4}}, new int[][]{{0, 4}});
    }

    /**
     * 输入: intervals = [[1,4],[2,3]]
     * 输出: [[1,4]]
     */
    @Test
    public void merge4() {
        invokeAndAssert(new int[][]{{1, 4}, {2, 3}}, new int[][]{{1, 4}});
    }

    private void invokeAndAssert(int[][] param, int[][] expect) {
        int[][] merge = solution.merge(param);
        Assert.assertArrayEquals(expect, merge);
    }

    @Test
    public void sortMerge() throws Exception {
        int[] merge = Whitebox.invokeMethod(solution, "merge", new int[]{1, 2}, 3, new int[]{4});
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, merge);
    }

    @Test
    public void sortMergeWithEmpty() throws Exception {
        int[] merge = Whitebox.invokeMethod(solution, "merge", new int[]{0, 1, 2}, 3, new int[]{});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, merge);
    }

    @Test
    public void sortMergeWithEmpty1() throws Exception {
        int[] merge = Whitebox.invokeMethod(solution, "merge", new int[]{}, 0, new int[]{1, 2, 3});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, merge);
    }

    @Test
    public void sortMergeWithEmpty2() throws Exception {
        int[] merge = Whitebox.invokeMethod(solution, "merge", new int[]{}, 0, new int[]{1});
        Assert.assertArrayEquals(new int[]{0, 1}, merge);
    }

    @Test
    public void sort() throws Exception {
        int[] sorted = Whitebox.invokeMethod(solution, "sort", new int[]{1, 3, 4, 54, 12, 3, 9, 0});
        log.info("sorted={}", sorted);
    }

}