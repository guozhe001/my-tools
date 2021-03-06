package com.nicai.algorithm.map;

import java.util.List;
import java.util.Map;

/**
 * MapSearch
 * 图的搜索
 * 如何用代码描述图：（图的定义：把点用线连起来就是计算机中的图）
 *
 * @author guozhe
 * @date 2020/09/07
 */
public interface MapSearch<K> {

    /**
     * 从图中查找,查找从start节点开始是否有到target节点的路径
     *
     * @param map    待查找的图
     * @param start  起始节点
     * @param target 查找的目标节点
     * @return 路径
     */
    boolean search(Map<K, List<K>> map, K start, K target);

}
