package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.Objects;

/**
 * 插入排序
 * 插入排序是一种从序列左端开始依次对数据进行排序的算法。
 * 在排序过程中，左侧的数据陆续归位，而右侧留下的就是还未被排序的数据。
 * 插入排序的思路就是从右侧的未排序区域内取出一个数据，然后将它插入到已排序区域内合适的位置上。
 *
 * @author guozhe
 * @date 2020/08/15
 */
@Slf4j
public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            /*
             * 比较范围：
             * 当i=0时，选择下标为0的数字，与前面的0个数字做比较
             * 当i=1时，选择下标为1的数字，与前面的1个数字做比较
             * 当i=2时，选择下标为2的数字，与前面的2个数字做比较
             * 当i=n-1时，选择下标为n-1的数字，与前面的n-1个数字做比较
             *
             * 比较与交换
             * 比较的下标顺序为从当前i-1开始，一直到下标为1为止
             * 比如当前比较的下标为j，如果下标为j位置的数字小于i，则停止比较
             *
             */
            int currentNum = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int num = nums[j];
                // 如果当前的数字小于待比较的数字
                if (currentNum < num) {
                    // 如果当前的数字小于j位置的数字，并且小于j-1位置的数字，则继续下一轮循环
                    if (j == 0 || currentNum >= nums[j - 1]) {
                        // System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)
                        System.arraycopy(nums, j, nums, j + 1, i - j);
                        nums[j] = currentNum;
                    }
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    /**
     * 插入排序的链表版实现，未完成
     *
     * @param node
     * @return
     */
    public Node sort(Node node) {
        // 获取链表长度
        int count = count(node);
        for (int i = 0; i < count; i++) {
            Node currentNode = getNode(node, i);
            for (int j = i - 1; j >= 0; j--) {
                Node beforeNode = getNode(node, j);
                if (currentNode.getNum() < beforeNode.getNum()) {
                    if (j == 0) {
                        Node currentNextNode = currentNode.getNextNode();
                        beforeNode.setNextNode(currentNextNode);
                        node.setNextNode(beforeNode);
                        node = currentNode;
                    } else {
                        Node node1 = getNode(node, j - 1);
                        if (node1.getNum() < currentNode.getNum()) {
                            node1.setNextNode(currentNode);
                            Node currentNextNode = currentNode.getNextNode();
                            currentNode.setNextNode(beforeNode.getNextNode());
                            beforeNode.setNextNode(currentNextNode);
                        }
                    }
                }
            }
        }
        return node;
    }

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public Logger getLogger() {
        return log;
    }


    private static Node getNode(Node node, int index) {
        int i = 0;
        Node result = node;
        while (i <= index) {
            if (Objects.isNull(node)) {
                throw new IndexOutOfBoundsException();
            }
            if (i == index) {
                break;
            }
            i++;
            result = result.getNextNode();
        }
        return result;
    }

    /**
     * 获取链表长度
     *
     * @param node 链表
     * @return 长度
     */
    private static int count(Node node) {
        int count = 0;
        Node tobeCounted = node;
        while (Objects.nonNull(tobeCounted)) {
            count++;
            tobeCounted = tobeCounted.getNextNode();
        }
        return count;
    }

}
