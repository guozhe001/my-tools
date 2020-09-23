package com.nicai.experience.p3c.chapterone.sixth;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

/**
 * 4. 【强制】在使用java.util.stream.Collectors类的toMap()方法转为Map集合时，一定要注
 * 意当 value 为 null 时会抛 NPE 异常。
 * 说明:在 java.util.HashMap 的 merge 方法里会进行如下的判断:
 * if (value == null || remappingFunction == null) throw new NullPointerException();
 * 反例:
 * List<Pair<String, Double>> pairArrayList = new ArrayList<>(2); pairArrayList.add(new Pair<>("version1", 8.3)); pairArrayList.add(new Pair<>("version2", null));
 * Map<String, Double> map = pairArrayList.stream().collect(
 * // 抛出 NullPointerException 异常
 * Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
 *
 * @author guozhe
 * @date 2020/09/23
 */
@RunWith(JMockit.class)
public class CollectorsToMapValueIsNullTest {

    @Tested
    private CollectorsToMapValueIsNull collectorsToMapValueIsNull;

    @Test
    public void toMapWithNullValue() {
        List<Pair<String, Double>> pairArrayList = Lists.newArrayList();
        pairArrayList.add(new Pair<>("version1", 8.3));
        pairArrayList.add(new Pair<>("version2", null));
        Assert.assertThrows(NullPointerException.class, () -> collectorsToMapValueIsNull.toMap(pairArrayList));
    }


    @Test
    public void toMapNoNullValue() {
        List<Pair<String, Double>> pairArrayList = Lists.newArrayList();
        pairArrayList.add(new Pair<>("version1", 8.3));
        pairArrayList.add(new Pair<>("version2", 6.5));
        Map<String, Double> stringDoubleMap = collectorsToMapValueIsNull.toMap(pairArrayList);
        Assert.assertEquals(2, stringDoubleMap.size());
    }


}