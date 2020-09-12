package com.nicai.algorithm.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.nicai.algorithm.map.MapSearchTest.*;

/**
 * ShortestPathTest
 *
 * @author guozhe
 * @date 2020/09/11
 */
@Slf4j
public class BaseShortestPathTest {

    private final List<ShortestPath<Location>> shortestPaths = Lists.newArrayList(new BellmanFord<>(), new Dijkstra<Location>());

    /**
     * 待搜索的图
     * src/main/resources/map/加权图.jpg
     * 假设这张图描述的是两地之间的时间，单位是小时
     */
    private static final Map<Location, List<AssignWeightsNode<Location>>> MAP = Maps.newHashMap();

    public void initMap() {
        MAP.clear();
        MAP.put(wuzhen, Lists.newArrayList(new AssignWeightsNode<>(hangzhou, 1)));
        MAP.put(hangzhou, Lists.newArrayList(new AssignWeightsNode<>(seoul, 10), new AssignWeightsNode<>(beijing, 6), new AssignWeightsNode<>(singapore, 7)));
        MAP.put(seoul, Lists.newArrayList(new AssignWeightsNode<>(hangzhou, 10), new AssignWeightsNode<>(tokyo, 3)));
        MAP.put(beijing, Lists.newArrayList(new AssignWeightsNode<>(hangzhou, 6), new AssignWeightsNode<>(tokyo, 4), new AssignWeightsNode<>(bangkok, 9),
                new AssignWeightsNode<>(singapore, 10)));
        MAP.put(singapore, Lists.newArrayList(new AssignWeightsNode<>(hangzhou, 7), new AssignWeightsNode<>(beijing, 10), new AssignWeightsNode<>(bangkok, 2)));
        MAP.put(tokyo, Lists.newArrayList(new AssignWeightsNode<>(seoul, 3), new AssignWeightsNode<>(beijing, 4), new AssignWeightsNode<>(bangkok, 12)));
        MAP.put(bangkok, Lists.newArrayList(new AssignWeightsNode<>(singapore, 2), new AssignWeightsNode<>(beijing, 9), new AssignWeightsNode<>(tokyo, 12)));
    }

    /**
     * 计算杭州到东京的最短时间
     */
    @Test
    public void search() {
        invokeAndAssert(10, hangzhou, tokyo);
    }

    /**
     * 计算
     * 乌镇到曼谷的最短时间
     */
    @Test
    public void search1() {
        invokeAndAssert(10, wuzhen, bangkok);
    }

    /**
     * 计算
     * 新加坡到首尔的最短时间
     */
    @Test
    public void search2() {
        invokeAndAssert(17, singapore, seoul);
    }

    /**
     * 计算
     * 首尔到曼谷的最短时间
     */
    @Test
    public void search3() {
        invokeAndAssert(15, seoul, bangkok);
    }

    private void invokeAndAssert(int expect, Location start, Location end) {
        for (ShortestPath<Location> shortestPath : shortestPaths) {
            Assert.assertEquals(expect, invokeSearch(shortestPath, start, end));
        }
    }

    private int invokeSearch(ShortestPath<Location> shortestPath, Location start, Location end) {
        initMap();
        int search = shortestPath.search(MAP, start, end);
        log.info("shortestPath={} form {} to {} at least spend {} hours", shortestPath, start, end, search);
        return search;
    }

}