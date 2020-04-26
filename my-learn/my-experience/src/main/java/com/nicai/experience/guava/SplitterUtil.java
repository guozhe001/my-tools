package com.nicai.experience.guava;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 字符串分割工具
 *
 * @author guozhe
 * @date 2020-04-01
 */
public class SplitterUtil {

    private SplitterUtil() {

    }

    /**
     * 分隔符
     */
    private static final String SPLIT = ",";

    /**
     * 使用guava的Splitter进行分割
     *
     * @param str 待分割的字符串
     * @return 分割后的字符串列表, list类型为java.util.Collections$UnmodifiableRandomAccessList
     */
    static List<String> guavaSplit(String str) {
        // 慎用此操作，得到的list不是期待的arrayList而是java.util.Collections$UnmodifiableRandomAccessList
        return com.google.common.base.Splitter.on(SPLIT).splitToList(str);
    }

    /**
     * 使用jdk的String类的split方法进行分割，然后转成ArrayList
     *
     * @param str 待分割的字符串
     * @return 分割后的字符串列表
     */
    static List<String> jdkSplit(String str) {
        return Lists.newArrayList(str.split(SPLIT));
    }

}
