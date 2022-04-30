package com.nicai.algorithm.book.algs4.practice.one;

import com.nicai.algorithm.datastructure.Queue;
import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;


/**
 * Practice1.3.6
 * 下面这段代码对队列q进行了什么操作？
 * 答：反转了队列
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice136 {

    public void reverse(Queue<String> q) {
        Stack<String> stack = new StackImpl<>();
        while (!q.isEmpty()) {
            stack.push(q.dequeue());
        }
        while (!stack.isEmpty()) {
            q.enqueue(stack.pop());
        }

    }
}
