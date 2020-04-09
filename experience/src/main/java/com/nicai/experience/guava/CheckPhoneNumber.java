package com.nicai.experience.guava;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;

import java.util.List;

public class CheckPhoneNumber {

    private static final String FORMAT = "%s%s%s%s";
    private static final List<String> ILLEGAL_STR = Lists.newArrayList();

    static {
        for (int i = 0; i < 7; i++) {
            String str = String.format(FORMAT, i, i + 1, i + 2, i + 3);
            ILLEGAL_STR.add(str);
            ILLEGAL_STR.add(StrUtil.reverse(str));
        }
        ILLEGAL_STR.forEach(System.out::println);
    }

    /**
     * 判断手机号码是否有超过四个连续的数字
     *
     * @param phoneNumber 手机号
     * @return 如果有超过四个连续的数字则返回true，否则返回false
     */
    public static boolean check(String phoneNumber) {
        for (String s : ILLEGAL_STR) {
            if (phoneNumber.contains(s)) {
                return true;
            }
        }
        return false;
    }

}
