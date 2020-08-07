package com.nicai.enums;

/**
 * 枚举有code和字符串时的接口
 *
 * @author guozhe
 * @date 2019/03/05
 */
public interface EnumTrait {

    /**
     * 获取枚举code
     *
     * @return 枚举code
     */
    int getCode();

    /**
     * 获取枚举描述
     *
     * @return 枚举描述
     */
    String getText();
}
