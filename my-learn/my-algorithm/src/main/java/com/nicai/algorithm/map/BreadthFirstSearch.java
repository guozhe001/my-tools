package com.nicai.algorithm.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * BreadthFirstSearch
 * 广度优先搜索，越靠近搜索节点，越先被搜索
 * 解决问题如下
 * 1、a点能不能到达b点
 * 2、从a点到b点的最短路径
 *
 * @author guozhe
 * @date 2020/09/07
 */
@Slf4j
public class BreadthFirstSearch<K> implements MapSearch<K> {

    @Override
    public boolean haveValue(Map<K, List<K>> map, K start, K end) {
        // 栈，存储待查找的元素
        final Queue<K> queue = new LinkedList<>();
        Set<K> searched = Sets.newHashSet();
        // 把起始节点能够叨叨的节点全部放在队列
        map.get(start).forEach(queue::offer);
        // 如果队列不为空
        while (!queue.isEmpty()) {
            // 获取队列的一个元素
            K pop = queue.poll();
            // 如果已经查找过了，则跳过此节点
            if (searched.contains(pop)) {
                continue;
            }
            log.info("pop={}", pop);
            // 如果此元素与待查找的目标元素相同，则说明找到了，返回true
            if (pop.equals(end)) {
                return true;
            } else {
                // 如果此元素不与目标元素相同，则把此元素的能够达到的节点全部加入到队列
                map.get(pop).forEach(queue::offer);
            }
            searched.add(pop);
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
