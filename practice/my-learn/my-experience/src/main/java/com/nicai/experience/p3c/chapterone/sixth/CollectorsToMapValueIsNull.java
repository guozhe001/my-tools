package com.nicai.experience.p3c.chapterone.sixth;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class CollectorsToMapValueIsNull {

    /**
     * 列表转换成map
     * 如果转换成map时的value为null，则抛NPE
     */
    public Map<String, Double> toMap(List<Pair<String, Double>> pairs) {
        return pairs.stream().collect(Collectors.toMap(Pair::getVersion, Pair::getValue, (v1, v2) -> v1));
    }

}
