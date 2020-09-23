package com.nicai.experience.p3c.chapterone.sixth;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListSubListTest
 *
 * @author guozhe
 * @date 2020/09/23
 */
@RunWith(JMockit.class)
public class ArrayListSubListTest {

    @Tested
    private ArrayListSubList arrayListSubList;

    @Test
    public void subListCanNotCastToArrayList() {
        Assert.assertThrows(ClassCastException.class, () -> {
            List<String> list = (ArrayList) arrayListSubList.subList(Lists.newArrayList("a", "b", "c", "d", "e", "f"), 0, 2);
        });
    }

    /**
     * 验证：修改了subList中的数据，原始的list的值也跟着一起修改了
     * p3c说明：
     * subList()返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，
     * 而是 ArrayList 的一个视 图，对于 SubList 的所有操作最终会反映到原列表上。
     */
    @Test
    public void subList() {
        ArrayList<String> strings1 = Lists.newArrayList("a", "b", "c", "d", "e", "f");
        List<String> strings = arrayListSubList.subList(strings1, 0, 2);
        strings.set(0, "b");
        Assert.assertEquals("b", strings1.get(0));
    }
}