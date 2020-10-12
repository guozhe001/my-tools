package com.nicai.algorithm.algs4.practice.one;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.nicai.algorithm.datastructure.Stack;
import com.nicai.algorithm.datastructure.impl.StackImpl;
import edu.princeton.cs.algs4.StdOut;

import java.util.List;
import java.util.Objects;

/**
 * Practice1.3.9
 * 1.3.9　编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入：1+2)*34)*56)))
 * 你的程序应该输出：((1+2)*((34)*(56)))
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice139 {


    private static final List<String> end = Lists.newArrayList(StrUtil.SLASH, "*");

    public void print(String[] strings) {
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
    public String[] fixParentheses(String[] toBeFix) {
        Stack<String> stack = new StackImpl<>();
        Stack<String> tempStack = new StackImpl<>();
        for (String s : toBeFix) {
            if (Parentheses.PARENTHESES_END.equals(s)) {
                tempStack.push(s);
                boolean isEnd = false;
                while (Objects.nonNull(stack.peek())) {
                    String pop = stack.pop();
                    if (end.contains(pop)) {
                        isEnd = true;
                        tempStack.push(Parentheses.PARENTHESES_START);
                        tempStack.push(pop);
                        break;
                    } else {
                        tempStack.push(pop);
                    }
                }
                if (!isEnd) {
                    tempStack.push(Parentheses.PARENTHESES_START);
                }
                pushToOtherStack(tempStack, stack);
            } else {
                stack.push(s);
            }
        }
        String[] result = new String[stack.size()];
        Stack<String> resultStack = new StackImpl<>();
        pushToOtherStack(stack, resultStack);
        for (int i = 0; i < result.length; i++) {
            result[i] = resultStack.pop();
        }
        return result;
    }


    private <T> void pushToOtherStack(Stack<T> source, Stack<T> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }
}
