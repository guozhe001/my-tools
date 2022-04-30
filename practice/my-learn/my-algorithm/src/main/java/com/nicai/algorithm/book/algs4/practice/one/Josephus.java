package com.nicai.algorithm.book.algs4.practice.one;

import com.nicai.algorithm.datastructure.Queue;
import com.nicai.algorithm.datastructure.impl.QueueImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * 1.3.37Josephus问题。
 * 在这个古老的问题中，N个身陷绝境的人一致同意通过以下方式减少生存人数。
 * 他们围坐成一圈（位置记为0到N-1）并从第一个人开始报数，报到M的人会被杀死，直到最后一个人留下来。
 * 传说中Josephus找到了不会被杀死的位置。
 * 编写一个Queue的用例Josephus，从命令行接受N和M并打印出人们被杀死的顺序（这也将显示Josephus在圈中的位置）。
 *
 * @author guozhe
 * @date 2020/10/14
 */
@Slf4j
public class Josephus {

    /**
     * Josephus问题
     *
     * @param n 人的个数
     * @param m 死亡数字
     * @return Josephus在哪个位置才能不死
     */
    public int josephus(int n, int m) {
        // TODO 未实现
        // 记录已经被杀死的人的位置
        int[] dead = new int[n];
        // 记录死亡位置的数组，每个位置的初始化值为-1，代表此位置的人还活着；如果此位置的人已经死了则值更新为此位置
        for (int i = 0; i < dead.length; i++) {
            dead[i] = -1;
        }
        // 记录已经被杀死的人数
        int deadNum = 0;
        Queue<Integer> queue = new QueueImpl<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        // 开始报数的人的位置
        int start = 0;
        // 如果活着的人数大于1，则继续报数杀人
        while ((n - deadNum) > 1) {
            int num = 0;
            while (!queue.isEmpty()) {
                Integer dequeue = queue.dequeue();
                num++;
                //
                if (num == m) {
                    log.info("people at index={} dead", dequeue);
                    dead[dequeue] = dequeue;
                    num = 0;
                }
            }
            deadNum++;
        }
        return 0;
    }


}
