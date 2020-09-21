package com.nicai.algorithm.datastructure;

import com.nicai.exception.NicaiException;

/**
 * 容量固定的栈
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class FixedCapacityStackOfStrings implements Stack<String> {

    /**
     * ¬
     * 保存集合的数组
     */
    private final String[] strings;

    /**
     * 当前容量
     */
    private int capacity;

    public FixedCapacityStackOfStrings(int size) {
        this.strings = new String[size];
    }

    @Override
    public boolean isEmpty() {
        // 如果当前的容量为0，说明为空
        return capacity == 0;
    }

    @Override
    public int size() {
        // 当前容量就是大小
        return capacity;
    }

    @Override
    public void push(String item) {
        // 如果当前的容量小于数组的长度，说明可以继续添加
        if (capacity < strings.length) {
            strings[capacity] = item;
            capacity++;
        } else {
            throw new NicaiException("栈已满，无法添加新的元素");
        }
    }

    @Override
    public String pop() {
        if (capacity > 0) {
            capacity--;
            return strings[capacity];
        } else {
            throw new NicaiException("栈已空，无法弹出元素");
        }
    }
}
