package com.nicai.algorithm.map;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * BreadthFirstSearch
 * 广度优先搜索，解决问题如下
 * 1、a点能不能到达b点
 * 2、从a点到b点的最短路径
 *
 * @author guozhe
 * @date 2020/09/07
 */
public class BreadthFirstSearch<K> implements MapSearch<K> {

    /**
     * 栈，存储待查找的元素
     */
    private final Queue<K> queue = new LinkedList<>();

    @Override
    public boolean haveValue(Map<K, List<K>> map, K start, K end) {
        // 把起始节点能够叨叨的节点全部放在队列
        map.get(start).forEach(queue::offer);
        // 如果队列不为空
        while (!queue.isEmpty()) {
            // 获取队列的一个元素
            K pop = queue.poll();
            // 如果此元素与待查找的目标元素相同，则说明找到了，返回true
            if (pop.equals(end)) {
                return true;
            } else {
                // 如果此元素不与目标元素相同，则把此元素的能够达到的节点全部加入到队列
                map.get(pop).forEach(queue::offer);
            }
        }
        // 如果没有查找到，返回false
        return false;
    }


    /**
     * 从图中查找,查找从start节点到end节点是否有路径
     *
     * @param map   待查找的图
     * @param start 起始节点
     * @param end   查找的目标节点
     * @return 路径
     */
    @Override
    public List<K> search(Map<K, List<K>> map, K start, K end) {
        // TODO
        return Lists.newArrayList();
    }

}
