package com.nicai.algorithm.map;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * BellmanFord
 * 贝尔曼 - 福特算法
 * 贝尔曼 - 福特(Bellman-Ford)算法是一种在图中求解最短路径问题的算法。
 * 最短路径问题就是在加权图指定了起点和终点的前提下，寻找从起点到终点的路径中权重总和最小的那条路径。
 *
 * @author guozhe
 * @date 2020/09/10
 */
public class BellmanFord<T> implements ShortestPath<T> {

    @Override
    public int search(Map<T, List<AssignWeightsNode<T>>> map, T start, T end) {
        // 记录从start节点到某个节点的权重
        Map<T, Integer> nodeWeightMap = Maps.newHashMap();
        Queue<AssignWeightsNode<T>> queue = new LinkedList<>();
        // 起点到起点的权重为0
        queue.offer(new AssignWeightsNode<>(start, 0));
        while (!queue.isEmpty()) {
            AssignWeightsNode<T> poll = queue.poll();
            int currentWeight = poll.getWeight();
            T node = poll.getNode();
            // 获取node的当前的权重
            Integer integer = nodeWeightMap.get(node);
//            NodeWeight.put(node, Objects.isNull(integer) ? poll.getWeight() : integer + poll.getWeight());
            map.get(node).forEach(nextNode -> {
                int lineWeight = nextNode.getWeight();
                Integer nextNodeWeight = nodeWeightMap.get(nextNode.getNode());
                // 如果下一个节点的权重是null，说明是第一次找到，更新此节点的权重为当前节点权重+边的权重
                if (Objects.isNull(nextNodeWeight)) {
                    nodeWeightMap.put(lineWeight + );
                }

            });

        }
        return NodeWeight.get(end);
    }

}
