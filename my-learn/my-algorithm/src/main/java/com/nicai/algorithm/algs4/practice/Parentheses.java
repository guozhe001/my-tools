package com.nicai.algorithm.algs4.practice;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Parentheses
 * 练习：1.3.4
 *
 * @author guozhe
 * @date 2020/09/28
 */
@Slf4j
public class Parentheses {

    /**
     * 花括号-左
     */
    public static final String DELIM_START = "{";
    /**
     * 花括号-右
     */
    public static final String DELIM_END = "}";
    /**
     * 中括号-左
     */
    public static final String BRACKET_START = "[";
    /**
     * 中括号-右
     */
    public static final String BRACKET_END = "]";
    /**
     * 圆括号-左
     */
    public static final String PARENTHESES_START = "(";
    /**
     * 圆括号-右
     */
    public static final String PARENTHESES_END = ")";

    private static final Map<String, String> PARENTHESES_MAP = Maps.newHashMap();

    static {
        PARENTHESES_MAP.put(DELIM_END, DELIM_START);
        PARENTHESES_MAP.put(BRACKET_END, BRACKET_START);
        PARENTHESES_MAP.put(PARENTHESES_END, PARENTHESES_START);
    }

    public boolean check(String string) {
        Stack<String> stack = new Stack<>();
        for (char a : string.toCharArray()) {
            String aString = String.valueOf(a);
            String corresponding = PARENTHESES_MAP.get(aString);
            // 如果a在map中，说明a是右边的括号；否则如果a不在map中，则说明a是左边的括号
            if (Objects.isNull(corresponding)) {
                stack.push(aString);
            } else {
                String pop = stack.pop();
                boolean equals = Objects.equals(corresponding, pop);
                // 如果括号不是一对，则返回false
                if (!equals) {
                    log.info("aString={} and pop={} is not Parentheses", aString, pop);
                    return Boolean.FALSE;
                }
                log.info("aString={} and pop={} is Parentheses", aString, pop);
            }
        }
        // 如果最终栈已经空了，说明所有的都已经进行了判断
        return stack.isEmpty();
    }
}
