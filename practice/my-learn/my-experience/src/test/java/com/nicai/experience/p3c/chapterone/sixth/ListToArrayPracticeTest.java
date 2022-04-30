package com.nicai.experience.p3c.chapterone.sixth;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表转数组练习
 *
 * @author guozhe
 * @date 2020/09/23
 */
public class ListToArrayPracticeTest {

    private static final List<String> STRINGS = Lists.newArrayList("a", "b", "c", "d", "e", "f");

    /**
     * 9.【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例:直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误。
     */
    @Test
    public void toArrayWrongWay() {
        Assert.assertThrows(ClassCastException.class, () -> {
            Object[] objects = (String[]) STRINGS.toArray();
        });
    }

    /**
     * 9.【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例:直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误。
     * 1) 等于 0，动态创建与 size 相同的数组，性能最好。
     */
    @Test
    public void toArrayBestWay() {
        toArrayAndAssert(new String[0]);
    }

    /**
     * 9.【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例:直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误。
     * <p>
     * 2) 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC 负担。
     */
    @Test
    public void toArrayRight2() {
        // TODO
//        toArrayAndAssert(new String[4]);
    }

    /**
     * 9.【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例:直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误。
     * <p>
     * 3) 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与 2 相同。
     */
    @Test
    public void toArrayRight3() {
        toArrayAndAssert(new String[STRINGS.size()]);
    }

    /**
     * 9.【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例:直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误。
     * <p>
     * 4) 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患。
     */
    @Test
    public void toArrayRight4() {
        toArrayAndAssert(new String[STRINGS.size() + 10]);
    }

    private void toArrayAndAssert(String[] strings) {
        ArrayList<String> newList = Lists.newArrayList(STRINGS);
        newList.toArray(strings);
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (i < newList.size()) {
                Assert.assertEquals(newList.get(i), string);
            } else {
                Assert.assertNull(string);
            }

        }
    }

}