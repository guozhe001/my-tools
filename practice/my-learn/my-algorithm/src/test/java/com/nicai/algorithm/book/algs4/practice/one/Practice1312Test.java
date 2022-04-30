package com.nicai.algorithm.book.algs4.practice.one;

import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Practice1312Test
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class Practice1312Test {

    @Test
    public void copy() {
        Stack<String> strings = new StackImpl<>();
        for (String s : new String[]{"a", "b", "c", "d"}) {
            strings.push(s);
        }
        Stack<String> copy = Practice1312.copy(strings);
        for (int i = 0; i < strings.size(); i++) {
            Assert.assertEquals(strings.pop(), copy.pop());
        }
    }
}