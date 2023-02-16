package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.collect.Lists;
import com.nicai.algorithm.MyTestCase;
import com.nicai.algorithm.leetcode.editor.cn.P8StringToIntegerAtoi.Solution;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P8StringToIntegerAtoiTest extends MyTestCase<String, Integer> {

    Solution solution = new P8StringToIntegerAtoi().new Solution();

    /**
     * // 示例 1：
     * //
     * //
     * //输入：s = "42"
     * //输出：42
     * //解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * //第 1 步："42"（当前没有读入字符，因为没有前导空格）
     * //         ^
     * //第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * //         ^
     * //第 3 步："42"（读入 "42"）
     * //           ^
     * //解析得到整数 42 。
     * //由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。
     */
    @Test
    public void myAtoi() {
        invokeAndAssert("42", 42);
    }

    /**
     * // 示例 2：
     * //
     * //
     * //输入：s = "   -42"
     * //输出：-42
     * //解释：
     * //第 1 步："   -42"（读入前导空格，但忽视掉）
     * //            ^
     * //第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     * //             ^
     * //第 3 步："   -42"（读入 "42"）
     * //               ^
     * //解析得到整数 -42 。
     * //由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
     * //
     * //
     */
    @Test
    public void myAtoi2() {
        invokeAndAssert("-42", -42);
    }

    /**
     * // 示例 2：
     * //
     * //
     * //输入：s = "   -42"
     * //输出：-42
     * //解释：
     * //第 1 步："   -42"（读入前导空格，但忽视掉）
     * //            ^
     * //第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     * //             ^
     * //第 3 步："   -42"（读入 "42"）
     * //               ^
     * //解析得到整数 -42 。
     * //由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
     * //
     * //
     */
    @Test
    public void myAtoi5() {
        invokeAndAssert("   -42", -42);
    }

    /**
     * // 示例 3：
     * //
     * //
     * //输入：s = "4193 with words"
     * //输出：4193
     * //解释：
     * //第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     * //         ^
     * //第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * //         ^
     * //第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     * //             ^
     * //解析得到整数 4193 。
     * //由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
     * //
     */
    @Test
    public void myAtoi3() {
        invokeAndAssert("4193 with words", 4193);
    }

    /**
     * // 示例 3：
     * //
     * //
     * //输入：s = "4193 with words"
     * //输出：4193
     * //解释：
     * //第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     * //         ^
     * //第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * //         ^
     * //第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     * //             ^
     * //解析得到整数 4193 。
     * //由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
     * //
     */
    @Test
    public void myAtoi4() {
        invokeAndAssert("words and 987", 0);
    }

//    @Test
//    public void isNum() {
//        Assert.assertTrue(solution.isNum('1'));
//    }
//
//    @Test
//    public void isNotNum() {
//        Assert.assertFalse(solution.isNum('a'));
//    }

    @Override
    protected Integer invoke(String param) {
        return solution.myAtoi(param);
    }

    @Test
    public void printNum() {
        log.info("Integer.MAX_VALUE={}, Integer.MIN_VALUE={}", Integer.MAX_VALUE, Integer.MIN_VALUE);
        log.info("Integer.MAX_VALUE/10={}, Integer.MIN_VALUE/10={}", Integer.MAX_VALUE / 10, Integer.MIN_VALUE / 10);
    }

    @Test
    public void trim() {
        List<String> strList = Lists.newArrayList(" a ", " a b ", " a b c", "a ", " a");
        strList.forEach(str -> {
            log.info("origin=={}==, trim=={}==", str, str.trim());
        });
    }


}