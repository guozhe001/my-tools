package com.nicai.algorithm.sort;

import lombok.Data;

@Data
public class Node {
    /**
     * 当前节点的值
     */
    private int num;

    /**
     * 下一个节点
     */
    private Node nextNode;
}
