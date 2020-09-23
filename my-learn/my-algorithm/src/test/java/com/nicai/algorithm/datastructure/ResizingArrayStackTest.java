package com.nicai.algorithm.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020/09/21
 */
@Slf4j
public class ResizingArrayStackTest {

    @Test
    public void push() {
        ResizingArrayStack<String> strings = new ResizingArrayStack<>();
        for (char c : "hello world".toCharArray()) {
            strings.push(String.valueOf(c));
        }
        for (String s : strings) {
            log.info("s={}", s);
        }
        Assert.assertEquals(11, strings.size());
        Assert.assertFalse(strings.isEmpty());
        String[] expect = {"d", "l", "r", "o", "w", " ", "o", "l", "l", "e", "h"};
        for (String s : expect) {
            Assert.assertEquals(s, strings.pop());
        }
    }


    @Test
    public void stack() {
        Stack<String> stringStack = new StackImpl<>();
        for (char c : "hello world".toCharArray()) {
            stringStack.push(String.valueOf(c));
        }
        for (String s : stringStack) {
            log.info("s={}", s);
        }
        Assert.assertEquals(11, stringStack.size());
        Assert.assertFalse(stringStack.isEmpty());
        String[] expect = {"d", "l", "r", "o", "w", " ", "o", "l", "l", "e", "h"};
        for (String s : expect) {
            Assert.assertEquals(s, stringStack.pop());
        }
    }


}