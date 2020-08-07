package com.nicai.constant;

import java.util.Random;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class Constants {

    private Constants() {
    }

    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGEXP = "/^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$/\n";

    /**
     * 随机数
     */
    public static final Random RANDOM = new Random();

    /**
     * 空字符串
     */
    public static final String BLANK = "";


}
