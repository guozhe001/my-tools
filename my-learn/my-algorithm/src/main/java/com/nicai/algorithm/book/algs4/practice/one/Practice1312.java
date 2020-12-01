package com.nicai.algorithm.book.algs4.practice.one;

import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;

/**
 * Practice1.3.12
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class Practice1312 {

    public static <T> Stack<T> copy(Stack<T> stack) {
        Stack<T> s = new StackImpl<>();
        for (T item : stack) {
            s.push(item);
        }
        Stack<T> result = new StackImpl<>();
        while (!s.isEmpty()) {
            result.push(s.pop());
        }
        return result;
    }
}
