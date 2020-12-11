package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class P860LemonadeChangeTest {

    private final P860LemonadeChange.Solution solution = new P860LemonadeChange().new Solution();

    /**
     * 示例 1：
     * <p>
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     */
    @Test
    public void lemonadeChange() {
        Assert.assertTrue(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }


    /**
     * 示例 2：
     * <p>
     * 输入：[5,5,10]
     * 输出：true
     */
    @Test
    public void lemonadeChange1() {
        Assert.assertTrue(solution.lemonadeChange(new int[]{5, 5, 10}));
    }

    /**
     * 示例 3：
     * <p>
     * 输入：[10,10]
     * 输出：false
     */
    @Test
    public void lemonadeChange2() {
        Assert.assertFalse(solution.lemonadeChange(new int[]{10, 10}));
    }

    /**
     * 示例 4：
     * <p>
     * 输入：[5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     */
    @Test
    public void lemonadeChange3() {
        Assert.assertFalse(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }

}