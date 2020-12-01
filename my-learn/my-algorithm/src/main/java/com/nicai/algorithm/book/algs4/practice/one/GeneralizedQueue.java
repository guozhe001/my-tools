package com.nicai.algorithm.book.algs4.practice.one;

/**
 * 1.3.38删除第k个元素。
 * 实现一个类并支持表1.3.12中的API：表1.3.12　泛型一般队列的API public class GeneralizedQueue<Item>
 * GeneralizedQueue():创建一条空队列
 * boolean isEmpty():队列是否为空
 * void insert(Item x):添加一个元素
 * Item delete(int k):删除并返回最早插入的第k个元素
 * 首先用数组实现该数据类型，然后用链表实现该数据类型。
 * 注意：我们在第3章中介绍的算法和数据结构可以保证insert()和delete()的实现所需的运行时间和和队列中的元素数量成对数关系
 *
 * @author guozhe
 * @date 2020/10/14
 */
public interface GeneralizedQueue<T> {
    /**
     * 队列是否为空
     *
     * @return 队列为空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 添加一个元素
     *
     * @param x 元素
     */
    void insert(T x);

    /**
     * 删除并返回最早插入的第k个元素
     *
     * @param k 需要删除的元素的序号
     * @return 第k个元素的值
     */
    T delete(int k);
}
