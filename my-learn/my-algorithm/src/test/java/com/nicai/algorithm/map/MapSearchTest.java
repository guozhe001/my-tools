package com.nicai.algorithm.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MapSearchTest {

    /**
     * 被测试类列表
     */
    private static final List<MapSearch<Location>> TO_BE_TESTED = Lists.newArrayList(new BreadthFirstSearch<>(),
            new DepthFirstSearch<>());

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
        MAP.put(seoul, Lists.newArrayList(hangzhou, tokyo));
        MAP.put(beijing, Lists.newArrayList(hangzhou));
        MAP.put(singapore, Lists.newArrayList(hangzhou, bangkok));
        MAP.put(tokyo, Lists.newArrayList(seoul));
        MAP.put(bangkok, Lists.newArrayList(singapore));
    }

    @Test
    public void haveValue() {
        TO_BE_TESTED.forEach(mapSearch -> Assert.assertTrue(invokeSearch(mapSearch, beijing)));
    }

    private boolean invokeSearch(MapSearch<Location> mapSearch, Location target) {
        log.info("mapSearch={}start=====================", mapSearch.getClass().getName());
        boolean result = mapSearch.search(MAP, wuzhen, target);
        log.info("mapSearch={}target=======================", mapSearch.getClass().getName());
        return result;
    }

    @Test
    public void haveNoValue() {
        TO_BE_TESTED.forEach(mapSearch -> Assert.assertFalse(invokeSearch(mapSearch, new Location("hello"))));
    }
}