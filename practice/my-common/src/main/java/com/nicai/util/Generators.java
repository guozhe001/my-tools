package com.nicai.util;

import java.util.*;

/**
 * 生成器
 *
 * @author guozhe
 */
public class Generators {

    /**
     * 把容器填充指定个数的数据
     *
     * @param collection 待填充的容器
     * @param generator  生成器
     * @param count      填充个数
     * @param <T>        填充类型
     * @return 填充后的容器
     */
    public static <T> List<T> fill(List<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    /**
     * 把容器填充指定个数的数据
     *
     * @param collection 待填充的容器
     * @param generator  生成器
     * @param count      填充个数
     * @param <T>        填充类型
     * @return 填充后的容器
     */
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    /**
     * 把容器填充指定个数的数据
     *
     * @param collection 待填充的容器
     * @param generator  生成器
     * @param count      填充个数
     * @param <T>        填充类型
     * @return 填充后的容器
     */
    public static <T> Queue<T> fill(Queue<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    /**
     * 把容器填充指定个数的数据
     *
     * @param collection 待填充的容器
     * @param generator  生成器
     * @param count      填充个数
     * @param <T>        填充类型
     * @return 填充后的容器
     */
    public static <T> LinkedList<T> fill(LinkedList<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    /**
     * 把容器填充指定个数的数据
     *
     * @param collection 待填充的容器
     * @param generator  生成器
     * @param count      填充个数
     * @param <T>        填充类型
     * @return 填充后的容器
     */
    public static <T> Set<T> fill(Set<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

}
