package com.nicai.experience.p3c.chapterone.sixth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 阿里巴巴Java开发手册
 * 3. 【强制】在使用java.util.stream.Collectors类的toMap()方法转为Map集合时，一定要使
 * 用含有参数类型为 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key
 * 值时会抛出 IllegalStateException 异常。
 * 说明:参数 mergeFunction 的作用是当出现 key 重复时，自定义对 value 的处理策略。
 * 正例:
 * List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
 * pairArrayList.add(new Pair<>("version", 6.19));
 * pairArrayList.add(new Pair<>("version", 10.24));
 * pairArrayList.add(new Pair<>("version", 13.14));
 * Map<String, Double> map = pairArrayList.stream().collect( // 生成的 map 集合中只有一个键值对:{version=13.14}
 * Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
 * 反例:
 * String[] departments = new String[] {"iERP", "iERP", "EIBU"}; // 抛出 IllegalStateException 异常
 * Map<Integer, String> map = Arrays.stream(departments)
 * .collect(Collectors.toMap(String::hashCode, str -> str));
 * <p>
 * nicai总结：
 * 这两种方法各有各的使用场景，并非必须使用阿里的建议：
 * 1、如果期待的数据的key必须不能重复，则直接跑异常会比较好；跑异常可以修复，如果直接merge不知道最终的value是哪一个
 * 2、如果期待的数据只要有值就行那么可以使用merge的方式覆盖
 *
 * @author guozhe
 * @date 2020-04-28
 */
public class CollectionToMap {

    private CollectionToMap() {
    }

    /**
     * 列表转换成map
     * 如果列表中有重复的key则抛异常
     * 如果value中存在null值会抛NPE
     *
     * @param pairs 列表
     * @return map
     */
    public static Map<String, Double> collectToMap(List<Pair> pairs) {
        return pairs.stream().collect(Collectors.toMap(Pair::getVersion, Pair::getValue));
    }

    /**
     * 列表转换成map
     * 如果列表中有重复的key则使用后面的一个覆盖前面的值
     * 如果value中存在null值会抛NPE
     *
     * @param pairs 列表
     * @return map
     */
    public static Map<String, Double> collectToMapMergeDuplicateKey(List<Pair> pairs) {
        return pairs.stream().collect(Collectors.toMap(Pair::getVersion, Pair::getValue, (v1, v2) -> v2));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pair {
        private String version;
        private Double value;
    }

}
