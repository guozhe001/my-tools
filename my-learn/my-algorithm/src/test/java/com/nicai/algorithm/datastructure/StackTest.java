package com.nicai.algorithm.datastructure;

import com.google.common.collect.Lists;
import com.nicai.algorithm.datastructure.impl.FixedCapacityStack;
import com.nicai.algorithm.datastructure.impl.ResizingArrayStack;
import com.nicai.algorithm.datastructure.impl.StackImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * StackTest
 *
 * @author guozhe
 * @date 2020/09/23
 */
@Slf4j
public class StackTest {

    private static final List<Stack<String>> TO_BE_TEST = Lists.newArrayList(new ResizingArrayStack<>(), new StackImpl<>());

    @Test
    public void push() {
        TO_BE_TEST.forEach(this::invokeStack);
    }

    private void invokeStack(Stack<String> stringStack) {
        log.info("Stack name ={}", stringStack.getClass().getName());
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

    /**
     * 测试字符串反转
     * 如输入["a", "b", "c"] 返回["c", "b", "a"]
     */
    public String[] reverse(String[] strings) {
        int length = strings.length;
        FixedCapacityStack<String> fixedCapacityStackOfStrings = new FixedCapacityStack<>(length);
        for (String s : strings) {
            fixedCapacityStackOfStrings.push(s);
        }
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = fixedCapacityStackOfStrings.pop();
        }
        return result;
    }

    @Test
    public void reverse() {
        String[] reverse = reverse(new String[]{"a", "b", "c"});
        Assert.assertEquals("c", reverse[0]);
        Assert.assertEquals("b", reverse[1]);
        Assert.assertEquals("a", reverse[2]);
    }

    /**
     * algs4练习题：1.3.2
     */
    @Test
    public void practice132() {
        invoke(new String[]{"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-"});
        Assert.assertTrue(true);
    }

    /**
     * algs4练习题：1.3.7
     */
    @Test
    public void practice137() {
        Stack<String> stack = new StackImpl<>();
        for (String s : new String[]{"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-"}) {
            stack.push(s);
        }
        int stackSize = stack.size();
        String peek = stack.peek();
        Assert.assertEquals(stackSize, stack.size());
        Assert.assertEquals("-", peek);
    }

    public void invoke(String[] strings) {
        Stack<String> stack = new StackImpl<>();
        for (String str : strings) {
            if (Objects.equals("-", str)) {
                log.info(stack.pop());
            } else {
                stack.push(str);
            }
        }
    }

}
