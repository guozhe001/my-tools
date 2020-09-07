package com.nicai.algorithm.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * MapSearchTest
 *
 * @author guozhe
 * @date 2020/09/07
 */
public class MapSearchTest {

    /**
     * 被测试类列表
     */
    private static final List<MapSearch<Location>> TO_BE_TESTED = Lists.newArrayList(new BreadthFirstSearch<>());

    /**
     * 图：src/main/resources/map/图-基础.jpg
     * 1、key是节点名称，value是与节点相关联的其他节点的名称
     * 2、节点是地点，value是地点能到达的另一个地点
     */
    private static final Map<Location, List<Location>> MAP = Maps.newHashMap();

    private static final Location wuzhen = new Location("乌镇");
    private static final Location hangzhou = new Location("杭州");
    private static final Location seoul = new Location("首尔");
    private static final Location beijing = new Location("北京");
    private static final Location tokyo = new Location("东京");
    private static final Location bangkok = new Location("曼谷");
    private static final Location singapore = new Location("新加坡");
    // 从乌镇到北京
    final List<Location> FORM_WUZHEN_TO_BEIJING = Lists.newArrayList(hangzhou, beijing);

    @BeforeClass
    public static void initMap() {
        MAP.put(wuzhen, Lists.newArrayList(hangzhou));
        MAP.put(hangzhou, Lists.newArrayList(seoul, beijing, singapore));
        MAP.put(seoul, Lists.newArrayList(hangzhou, beijing, tokyo));
        MAP.put(beijing, Lists.newArrayList(hangzhou, seoul, tokyo, bangkok, singapore));
        MAP.put(singapore, Lists.newArrayList(hangzhou, beijing, bangkok));
        MAP.put(tokyo, Lists.newArrayList(seoul, beijing, bangkok));
        MAP.put(bangkok, Lists.newArrayList(singapore, beijing, tokyo));
    }

    @Test
    public void search() {
        TO_BE_TESTED.forEach(mapSearch -> Assert.assertTrue(mapSearch.haveValue(MAP, wuzhen, beijing)));
    }
}