package com.nicai.algorithm.algs4.practice.one;

import org.junit.Test;

/**
 * Practice139Test
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class Practice139Test {

    @Test
    public void fixParentheses() {
        Practice139 practice139 = new Practice139();
        String[] strings = new String[]{"1", "+", "2", ")", "*", "34", ")", "*", "56", ")", ")", ")"};
        practice139.print(strings);
        practice139.print(practice139.fixParentheses(strings));
    }
}