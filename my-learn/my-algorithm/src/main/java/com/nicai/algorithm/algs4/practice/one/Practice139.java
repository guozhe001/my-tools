package com.nicai.algorithm.algs4.practice.one;

import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Practice1.3.9
 * 1.3.9　编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入：1+2)*34)*56)))
 * 　你的程序应该输出：((1+2)*((34)*(56)))
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice139 {

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        print(strings);
        print(fixParentheses(strings));
    }

    private static void print(String[] strings) {
        for (String s : strings) {
            StdOut.print(s);
        }
        StdOut.println();
    }

    /**
     * 补全括号
     *
     * @param toBeFix 带补全的字符串
     */
    private static String[] fixParentheses(String[] toBeFix) {
        // TODO
        Stack<String> stack = new StackImpl<>();
        for (String s : toBeFix) {
            stack.push(s);
        }
        return null;
    }

}
