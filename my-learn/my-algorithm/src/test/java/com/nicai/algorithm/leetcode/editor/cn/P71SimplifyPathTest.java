package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class P71SimplifyPathTest {

    private final P71SimplifyPath.Solution solution = new P71SimplifyPath().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     */
    @Test
    public void simplifyPath() {
        invokeAndAssert("/home/", "/home");
    }

    /**
     * 示例 2：
     * <p>
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     */
    @Test
    public void simplifyPath2() {
        invokeAndAssert("/../", "/");
    }

    /**
     * 示例 3：
     * <p>
     * 输入："/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     */
    @Test
    public void simplifyPath3() {
        invokeAndAssert("/home//foo/", "/home/foo");
    }

    /**
     * 示例 4：
     * <p>
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     */
    @Test
    public void simplifyPath4() {
        invokeAndAssert("/a/./b/../../c/", "/c");
    }


    /**
     * 示例 5：
     * <p>
     * 输入："/a/../../b/../c//.//"
     * 输出："/c"
     */
    @Test
    public void simplifyPath5() {
        invokeAndAssert("/a/../../b/../c//.//", "/c");
    }

    /**
     * 示例 6：
     * <p>
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     */
    @Test
    public void simplifyPath6() {
        invokeAndAssert("/a//b////c/d//././/..", "/a/b/c");
    }

    private void invokeAndAssert(String input, String expect) {
        String actual = solution.simplifyPath(input);
        log.info("input={}, expect={}, actual={}", input, expect, actual);
        Assert.assertEquals(expect, actual);
    }
}