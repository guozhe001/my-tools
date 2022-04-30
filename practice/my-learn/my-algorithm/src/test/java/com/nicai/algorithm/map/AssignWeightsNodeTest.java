package com.nicai.algorithm.map;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * AssignWeightsNodeTest
 *
 * @author guozhe
 * @date 2020/09/10
 */
@Slf4j
public class AssignWeightsNodeTest {

    /**
     * 学校
     */
    private static final Location school = new Location("学校");

    /**
     * 家
     */
    private static final Location home = new Location("家");

    /**
     * 假设你家在山上，学校在山下
     * 你每天步行上学
     * 那么理论上你上学花费的时间应该比放学回家花费的时间短，因为上学是下坡，放学回家是上坡
     */
    @Test
    public void test() {
        /*
         上学和放学，有时间权重的图，其中加权节点的node是地址，权重是时间（单位分钟）
         这里表示上学花费10mins，放学回家花费15mins
         */
        Map<Location, AssignWeightsNode<Location>> map = Maps.newHashMap();
        map.put(home, new AssignWeightsNode<>(school, 10));
        map.put(school, new AssignWeightsNode<>(home, 15));
        map.forEach((k, v) -> log.info("form {} to {} need {} mins", k, v.getNode(), v.getWeight()));
        Assert.assertTrue(true);
    }

}