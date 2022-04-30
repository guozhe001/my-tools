package com.nicai.experience.p3c.chapterone.sixth;

import cn.hutool.core.lang.Assert;

import java.util.List;

/**
 * subList实践
 *
 * @author guozhe
 * @date 2020/09/23
 */
public class SubListPractice {

    /**
     * 5. 【强制】ArrayList 的 subList 结果不可强转成 ArrayList，
     * 否则会抛出 ClassCastException 异常:java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
     * 说明:
     * subList()返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，
     * 而是 ArrayList 的一个视 图，对于 SubList 的所有操作最终会反映到原列表上。
     *
     * @param list      需要获取子列表的列表
     * @param fromIndex 开始下标
     * @param toIndex   结束下标
     * @param <T>       列表中的数据类型
     * @return 传入的list的下标大于等于fromIndex小于toIndex的视图
     */
    public <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
        Assert.isTrue(list.size() > 2);
        return list.subList(fromIndex, toIndex);
    }


}
