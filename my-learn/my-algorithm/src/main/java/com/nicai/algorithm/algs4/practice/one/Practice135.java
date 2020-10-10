package com.nicai.algorithm.algs4.practice.one;

import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;
import edu.princeton.cs.algs4.StdOut;


/**
 * Practice1.3.5
 * 当N为50时下面这段代码会打印什么？
 * 答：打印N的二进制表示（当N为50时打印110010）。
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice135 {

    public void print(int n) {
        Stack<Integer> stack = new StackImpl<>();
        // 0, 1, 0, 0, 1, 1
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        for (int d : stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }
}
