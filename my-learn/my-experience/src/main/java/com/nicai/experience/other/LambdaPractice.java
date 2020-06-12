package com.nicai.experience.other;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author guozhe
 * @date 2020/6/12
 */
public class LambdaPractice {


    /**
     * 在传入的列表中查找第一个前缀为prefix的数据;如果列表中没有合适的数据则返回null
     * 反例
     *
     * @param strings 待查找的字符串列表
     * @param prefix  前缀
     * @return 列表中前缀为传入前缀的第一个
     */
    static String findOrElseGetWrongWay(List<String> strings, final String prefix) {
        // orElseGet方法不能传入null，否则会抛NPE；源码有提示，但是编译并不会报错
        return strings.stream().filter(str -> StringUtils.startsWith(str, prefix)).findFirst().orElseGet(null);
    }

    /**
     * 在传入的列表中查找第一个前缀为prefix的数据;如果列表中没有合适的数据则返回null
     * 正例
     *
     * @param strings 待查找的字符串列表
     * @param prefix  前缀
     * @return 列表中前缀为传入前缀的第一个
     */
    static String findOrElseGetRightWay(List<String> strings, final String prefix) {
        Optional<String> first = strings.stream().filter(str -> StringUtils.startsWith(str, prefix)).findFirst();
        return first.isPresent() ? first.get() : null;
    }
}
