package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P283MoveZeroesTest
 *
 * @author guozhe
 * @date 2020/10/20
 */
public class P283MoveZeroesTest {

    private final P283MoveZeroes.Solution solution = new P283MoveZeroes().new Solution();

    @Test
    public void moveZeroes() {
        int[] ints = {0, 1, 0, 3, 12};
        solution.moveZeroes(ints);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ints);
    }

    @Test
    public void moveZeroes1() {
        int[] ints = {0, 0};
        solution.moveZeroes(ints);
        Assert.assertArrayEquals(new int[]{0, 0}, ints);
    }

    @Test
    public void moveZeroesMoveZero() {
        int[] ints = {0, 1, 0, 3, 12};
        solution.moveZeroesMoveZero(ints);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ints);
    }

    @Test
    public void moveZeroesMoveZero1() {
        int[] ints = {0, 0};
        solution.moveZeroesMoveZero(ints);
        Assert.assertArrayEquals(new int[]{0, 0}, ints);
    }

    @Test
    public void moveZeroesTwoLoop() {
        int[] ints = {0, 1, 0, 3, 12};
        solution.moveZeroesTwoLoop(ints);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ints);
    }

    @Test
    public void moveZeroesTwoLoop1() {
        int[] ints = {0, 0};
        solution.moveZeroesTwoLoop(ints);
        Assert.assertArrayEquals(new int[]{0, 0}, ints);
    }

}