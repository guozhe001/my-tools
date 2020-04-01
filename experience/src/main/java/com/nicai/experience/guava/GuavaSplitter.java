package com.nicai.experience.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author guozhe
 * @date 2020-04-01
 */
class GuavaSplitter {

    private GuavaSplitter() {

    }

    /**
     * 分隔符
     */
    private static final String SPLIT = ",";

    static List<String> guavaSplit(String str) {
        // 慎用此操作，得到的list不是期待的arrayList
        return Splitter.on(SPLIT).splitToList(str);
    }

    static List<String> jdkSplit(String str) {
        return Lists.newArrayList(str.split(SPLIT));
    }

}
