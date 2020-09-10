package com.nicai.algorithm.map;

import java.util.List;
import java.util.Map;

/**
 * ShortestPath
 *
 * @author guozhe
 * @date 2020/09/10
 */
public interface ShortestPath<T> {

    /**
     * 从起点到终点的路径中权重总和最小的那条路径
     *
     * @param map   图
     * @param start 起点
     * @param end   终点
     * @return 最短路径的权重之和
     */
    int search(Map<T, List<AssignWeightsNode<T>>> map, T start, T end);
}
