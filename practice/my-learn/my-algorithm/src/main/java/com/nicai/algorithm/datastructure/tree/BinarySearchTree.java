package com.nicai.algorithm.datastructure.tree;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.*;

@Slf4j
@Data
@ToString
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    private int count;

    public BinarySearchTree() {
    }

    public void print() {
        log.info("中序遍历 start==============");
        middleOrderTraversal(root);
        log.info("中序遍历 end==============");

        log.info("先序遍历 start==============");
        preorderTraversal(root);
        log.info("先序遍历 end==============");

        log.info("后序遍历 start==============");
        postorderTraversal(root);
        log.info("后序遍历 end==============");

        log.info("中序遍历，非递归 start==============");
        inorderTraversal(root);
        log.info("中序遍历，非递归 end==============");

    }

    /**
     * 中序遍历：输出的子树根的关键字在左子树关键字和右子树关键字之间
     *
     * @param node 遍历开始的节点
     */
    private void middleOrderTraversal(Node<T> node) {
        if (Objects.nonNull(node)) {
            middleOrderTraversal(node.left);
            log.info("{}", node.value);
            middleOrderTraversal(node.right);
        }
    }

    public void inorderTraversal(Node<T> root) {
        Node<T> node = root;
        Deque<Node<T>> stk = new LinkedList<>();
        while (node != null || !stk.isEmpty()) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            log.info("{}", node.value);
            node = node.right;
        }
    }

    /**
     * 先序遍历：根关键字在其左右子树之前输出
     *
     * @param node 遍历开始的节点
     */
    private void preorderTraversal(Node<T> node) {
        if (Objects.nonNull(node)) {
            log.info("{}", node.value);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    /**
     * 后序遍历：根关键字在其左右子树之后输出
     *
     * @param node 遍历开始的节点
     */
    private void postorderTraversal(Node<T> node) {
        if (Objects.nonNull(node)) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            log.info("{}", node.value);
        }
    }


    public void add(T value) {
        if (Objects.isNull(root)) {
            root = new Node<>();
            root.value = value;
            root.parent = null;
        } else {
            add(root, value);
        }
        count++;
    }

    /**
     * 把value添加到二叉查找树
     *
     * @param node  添加到的节点
     * @param value 添加的value
     */
    private void add(Node<T> node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (Objects.nonNull(node.left)) {
                add(node.left, value);
            } else {
                node.left = newNode(node, value);
            }
        } else {
            if (Objects.nonNull(node.right)) {
                add(node.right, value);
            } else {
                node.right = newNode(node, value);
            }
        }
    }

    private Node<T> newNode(Node<T> parent, T value) {
        Node<T> newNode = new Node<>();
        newNode.parent = parent;
        newNode.value = value;
        return newNode;
    }

    @Data
    @ToString
    public static class Node<T extends Comparable<T>> {

        private T value;

        private Node<T> parent;

        private Node<T> left;

        private Node<T> right;
    }
}
