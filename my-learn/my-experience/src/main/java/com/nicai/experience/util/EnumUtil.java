package com.nicai.experience.util;

import com.nicai.experience.exception.NicaiException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 枚举工具类
 *
 * @author guozhe
 */
@Slf4j
public class EnumUtil {

    /**
     * 字符串分割符
     */
    private static final String SPLIT = ", ";

    private EnumUtil() {

    }

    /**
     * 根据字符串获取对应的枚举
     *
     * @param enumType 转换的目标枚举类型
     * @param name     待转换的字符
     * @param message  目标枚举类型的描述，转换失败则抛出包含此信息的异常
     * @param <T>      转换的目标枚举类型
     * @return 字符串对应的枚举值s
     */
    public static <T extends Enum<T>> T getValue(Class<T> enumType, String name, String message) {
        try {
            return Enum.valueOf(enumType, name);
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            throw new NicaiException(String.format("%s不能为空", message), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new NicaiException(String.format("不支持的【%s】：【%s】，支持的值包括：【%s】", message, name, getEnumValuesString(enumType)), e);
        }
    }

    /**
     * 获取某个枚举类的所有name
     *
     * @param enumType 枚举类型Class
     * @param <T>      枚举类型
     * @return 枚举类的所有name，以逗号分割
     */
    private static <T extends Enum<T>> String getEnumValuesString(Class<T> enumType) {
        return Arrays.stream(enumType.getEnumConstants()).map(Enum::name).collect(Collectors.joining(SPLIT));
    }

}


