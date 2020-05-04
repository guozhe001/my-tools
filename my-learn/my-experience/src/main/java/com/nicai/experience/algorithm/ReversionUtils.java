package com.nicai.experience.algorithm;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guozhe
 */
@Slf4j
public class ReversionUtils {
    private static final int TEN = 10;

    private ReversionUtils() {
    }

    /**
     * 整数反转
     * 如：
     * 123->321
     * 1230->321
     *
     * @param num 待反转的整数
     * @return 反转后的整数
     */
    public static int intReversion(int num) {

        Assert.isTrue(num >= 0);
        int temp = Integer.valueOf(num).intValue();
        int result = 0;
        while (true) {
            // 获取此数字的位数
            int digits = getDigits(temp);
            // 如果超过一位数字
            if (digits >= 1) {
                // 最后一位
                int last = temp % TEN;
                result = (last * pow(TEN, digits - 1)) + result;
                temp /= TEN;
                if (digits == 1) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 幂运算
     *
     * @param num 数字
     * @param a   power
     * @return num的a次幂
     */
    static int pow(int num, int a) {
        return (int) Math.pow(num, a);
    }

    /**
     * 获取一个数字的位数
     *
     * @param num 数字
     * @return 传入数字的位数
     */
    static int getDigits(int num) {
        return String.valueOf(num).getBytes().length;
    }

}
