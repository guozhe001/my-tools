package com.nicai.algorithm.map;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * 迪克斯特拉算法
 *
 * @author guozhe
 * @date 2020/09/12
 */
public class Dijkstra<T> implements ShortestPath<T> {

    @Override
    public int search(Map<T, List<AssignWeightsNode<T>>> map, T start, T end) {
        // 保存候补节点的队列
        Stack<T> queue = new Stack<>();
        // 保存从起始节点到当前节点权重的map
        Map<T, Integer> weightMap = Maps.newHashMap();
        Map<T, Set<T>> parentMap = Maps.newHashMap();
        queue.push(start);
        // 起始节点到起始节点的权重是0
        weightMap.put(start, 0);
        while (!queue.isEmpty()) {
            T parentNode = queue.pop();
            // 获取当前节点的权重
            Integer parentWeight = weightMap.get(parentNode);
            //更新当前节点可以直接到达的自节点的权重
            List<AssignWeightsNode<T>> assignWeightsNodes = map.get(parentNode);
            // 当前节点到子节点权重小的
            AssignWeightsNode<T> minWeightNode = null;
            for (AssignWeightsNode<T> assignWeightsNode : assignWeightsNodes) {
                T childNode = assignWeightsNode.getNode();
                // 如果此节点的父节点
                Set<T> parents = parentMap.get(childNode);
                if (Objects.nonNull(parents) && parents.contains(parentNode)) {
                    continue;
                }
                Integer childWeight = weightMap.get(childNode);
                int weight = Objects.isNull(childWeight) ? parentWeight + assignWeightsNode.getWeight() :
                        Math.min(childWeight, parentWeight + assignWeightsNode.getWeight());
                weightMap.put(childNode, weight);
                // 如果
                if (Objects.isNull(minWeightNode) || weight < minWeightNode.getWeight()) {
                    minWeightNode = assignWeightsNode;
                }
                if (CollUtil.isEmpty(parents)) {
                    parents = Sets.newHashSet();
                    parents.add(parentNode);
                    parentMap.put(childNode, parents);
                } else {
                    parents.add(parentNode);
                }
            }
            if (Objects.nonNull(minWeightNode)) {
                assignWeightsNodes.remove(minWeightNode);
                assignWeightsNodes.forEach(a -> queue.push(a.getNode()));
                queue.push(minWeightNode.getNode());
            }
        }
        return weightMap.get(end);
    }
}
