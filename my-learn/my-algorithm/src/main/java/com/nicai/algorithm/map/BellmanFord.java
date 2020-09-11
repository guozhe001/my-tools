package com.nicai.algorithm.map;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

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
        // 记录节点的父节点，如果从父节点到子节点已经搜过了，则下次不再做从子节点到父节点搜索了
        Map<T, Set<T>> parentMap = Maps.newHashMap();
        nodeWeightMap.put(start, 0);
        // 起点到起点的权重为0
        queue.offer(new AssignWeightsNode<>(start, 0));
        while (!queue.isEmpty()) {
            AssignWeightsNode<T> poll = queue.poll();
            final T parentNode = poll.getNode();
            // 获取当前节点的权重
            int currentWeight = nodeWeightMap.get(parentNode);
            // 遍历当前节点的所有子节点
            for (AssignWeightsNode<T> assignWeightsNode : map.get(parentNode)) {
                T childNode = assignWeightsNode.getNode();
                // 获取当前节点的所有节点
                Set<T> parents = parentMap.get(childNode);
                // 如果当前节点的子节点也是当前节点的父节点，则不更新其父节点，直接跳过
                if (CollUtil.isNotEmpty(parents) && parents.contains(parentNode)) {
                    continue;
                }
                int lineWeight = assignWeightsNode.getWeight();
                Integer nextNodeWeight = nodeWeightMap.get(childNode);
                // 如果下一个节点的权重是null，说明是第一次找到，更新此节点的权重为当前节点权重+边的权重
                if (Objects.isNull(nextNodeWeight)) {
                    nodeWeightMap.put(childNode, lineWeight + currentWeight);
                } else {
                    // 如果下一个节点有权重，对比权重
                    nodeWeightMap.put(childNode, nextNodeWeight > lineWeight + currentWeight ? lineWeight + currentWeight : nextNodeWeight);
                }
                queue.offer(assignWeightsNode);
                if (CollUtil.isEmpty(parents)) {
                    parentMap.put(childNode, Sets.newHashSet(parentNode));
                } else {
                    parents.add(parentNode);
                }
            }
        }
        return nodeWeightMap.get(end);
    }

}
