package com.nicai.algorithm.other;

import cn.hutool.core.lang.Assert;

/**
 * 欧几里得最大公约数算法
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class EuclideanGreatestCommonDivisor {

    /**
     * 求解最大公约数
     *
     * @param x 数值x
     * @param y 数值y
     * @return x和y的最大公约数
     */
    public int gcd(int x, int y) {
        Assert.isTrue(x > 0 && y > 0);
        // 使用较大的数除以较小的数获得余数
        int mod = Math.max(x, y) % Math.min(x, y);
        // 如果余数等于0，则说明能够被整出，说明最大公约数就是较小的数
        if (mod == 0) {
            return Math.min(x, y);
        }
        // 如果不能整出，则使用余数和较小的数继续使用相同的算法求gcd
        return gcd(mod, Math.min(x, y));
    }
}
