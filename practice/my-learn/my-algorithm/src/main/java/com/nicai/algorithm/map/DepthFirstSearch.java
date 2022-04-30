package com.nicai.algorithm.map;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * DepthFirstSearch
 * <p>
 * 深度优先搜索，顺着某个节点一直往下查找，直到某个节点没有子节点再换另一个节点做同样的查找
 * 解决问题：
 * 1、是否有路径
 *
 * @author guozhe
 * @date 2020/09/10
 */
@Slf4j
public class DepthFirstSearch<K> implements MapSearch<K> {

    @Override
    public boolean search(Map<K, List<K>> map, K start, K target) {
        // 用于存储候补节点的栈
        Stack<K> stack = new Stack<>();
        // 记录被搜索过的节点
        List<K> searched = Lists.newArrayList();
        map.get(start).forEach(stack::push);
        while (!stack.isEmpty()) {
            // 弹出一个元素
            K pop = stack.pop();
            // 如果已经被搜索过，则直接跳过
            if (searched.contains(pop)) {
                continue;
            }
            log.info("pop={}", pop);
            // 如果当前元素是被查找的元素，则返回true
            if (pop.equals(target)) {
                return true;
            } else {
                // 把被搜索过的节点加入被搜索的列表中
                searched.add(pop);
                // 否则把此节点的所有子节点压入栈中继续查找
                map.get(pop).forEach(stack::push);
            }
        }
        return false;
    }
}
