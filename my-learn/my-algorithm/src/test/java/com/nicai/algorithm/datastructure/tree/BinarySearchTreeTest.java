package com.nicai.algorithm.datastructure.tree;

import cn.hutool.core.util.RandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {


    @Test
    public void add() {
        BinarySearchTree<Integer> integerBinarySearchTree = new BinarySearchTree<>();
        IntStream.range(0, 100).forEach(i -> integerBinarySearchTree.add(RandomUtil.randomInt(0, 100)));
        Assert.assertEquals(100, integerBinarySearchTree.getCount());
        integerBinarySearchTree.print();
    }

}