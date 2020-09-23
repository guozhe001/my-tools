package com.nicai.experience.p3c.chapterone.sixth;

import cn.hutool.core.lang.Assert;

import java.util.List;

/**
 * 5. 【强制】ArrayList 的 subList 结果不可强转成 ArrayList，
 * 否则会抛出 ClassCastException 异常:java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
 * 说明:
 * subList()返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，
 * 而是 ArrayList 的一个视 图，对于 SubList 的所有操作最终会反映到原列表上。
 *
 * @author guozhe
 * @date 2020/09/23
 */
public class ArrayListSubList {

    /**
     *
     * @param list
     * @param <T>
     * @return
     */
    public <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
        Assert.isTrue(list.size() > 2);
        return list.subList(fromIndex, toIndex);
    }

}
