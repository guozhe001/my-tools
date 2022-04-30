package com.nicai.experience.p3c.chapterone.sixth;

import lombok.extern.slf4j.Slf4j;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * ArrayListSubListTest
 *
 * @author guozhe
 * @date 2020/09/23
 */
@Slf4j
@RunWith(JMockit.class)
public class SubListPracticeTest {

    private static final List<String> STRINGS = Lists.newArrayList("a", "b", "c", "d", "e", "f");
    @Tested
    private SubListPractice subListPractice;

    /**
     * 5. 【强制】ArrayList 的 subList 结果不可强转成 ArrayList，
     * 否则会抛出 ClassCastException 异常:java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
     * 说明:
     * subList()返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，
     * 而是 ArrayList 的一个视 图，对于 SubList 的所有操作最终会反映到原列表上。
     */
    @Test
    public void subListCanNotCastToArrayList() {
        Assert.assertThrows(ClassCastException.class, () -> {
            List<String> subList = (ArrayList) subListPractice.subList(Lists.newArrayList(STRINGS), 0, 2);
        });
    }

    /**
     * 验证：修改了subList中的数据，原始的list的值也跟着一起修改了
     * p3c说明：
     * subList()返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，
     * 而是 ArrayList 的一个视 图，对于 SubList 的所有操作最终会反映到原列表上。
     */
    @Test
    public void subListIsAView() {
        List<String> originalList = Lists.newArrayList(STRINGS);
        List<String> subList = subListPractice.subList(originalList, 0, 2);
        subList.set(0, "b");
        Assert.assertEquals("b", originalList.get(0));
    }


    /**
     * 验证：subList的fromIndex和toIndex左闭右开
     */
    @Test
    public void subListIndex() {
        List<String> subList = subListPractice.subList(Lists.newArrayList(STRINGS), 0, 3);
        Assert.assertEquals(3, subList.size());
        Assert.assertEquals("a", subList.get(0));
        Assert.assertEquals("b", subList.get(1));
        Assert.assertEquals("c", subList.get(2));
    }

    /**
     * 8. 【强制】在subList场景中，高度注意对父集合元素的增加或删除，均会导致子列表的遍历、
     * 增加、删除产生 ConcurrentModificationException 异常。
     * 添加
     */
    @Test
    public void subListParentListAdd() {
        List<String> originalList = Lists.newArrayList(STRINGS);
        List<String> subList = subListPractice.subList(originalList, 0, 3);
        print(subList);
        originalList.add("z");
        Assert.assertThrows(ConcurrentModificationException.class, () -> print(subList));
    }

    /**
     * 8. 【强制】在subList场景中，高度注意对父集合元素的增加或删除，均会导致子列表的遍历、
     * 增加、删除产生 ConcurrentModificationException 异常。
     * 删除
     */
    @Test
    public void subListParentListDelete() {
        List<String> originalList = Lists.newArrayList(STRINGS);
        List<String> subList = subListPractice.subList(originalList, 0, 3);
        print(subList);
        originalList.remove(originalList.size() - 1);
        Assert.assertThrows(ConcurrentModificationException.class, () -> print(subList));
    }

    private void print(List<String> subList) {
        subList.forEach(log::info);
    }

}