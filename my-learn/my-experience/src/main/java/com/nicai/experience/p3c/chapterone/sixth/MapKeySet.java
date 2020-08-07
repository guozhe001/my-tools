package com.nicai.experience.p3c.chapterone.sixth;

import com.nicai.constant.Constants;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 阿里巴巴Java开发手册
 * 6. 【强制】使用Map的方法keySet()/values()/entrySet()返回集合对象时，
 * 不可以对其进行添 加元素操作，否则会抛出 UnsupportedOperationException 异常。
 * <p>
 * <pre>
 * nicai总结：
 * 以HashMap为例
 * map.keySet():因为keySet方法返回的Set类型为KeySet,其继承关系链为KeySet extends AbstractSet，AbstractSet extends AbstractCollection
 * AbstractCollection#add方法会直接抛UnsupportedOperationException异常
 * <p>
 * map.values():values方法返回的类型为Values，其继承关系链为Values extends AbstractCollection
 * <p>
 * map.entrySet():entrySet方法返回的类型为EntrySet，其继承关系链为EntrySet extends AbstractSet，AbstractSet extends AbstractCollection
 *
 * @author guozhe
 * @date 2020-04-28
 */
public class MapKeySet {

    private MapKeySet() {

    }

    public static void addKeySet(Map<Integer, Double> map) {
        Set<Integer> keys = map.keySet();
        keys.add(Constants.RANDOM.nextInt());
    }

    /**
     * 可以remove 不影响map对象
     *
     * @param map 待操作的map
     */
    public static void removeKeySet(Map<Integer, Double> map) {
        Set<Integer> keys = map.keySet();
        keys.remove(0);
    }

    public static void addValues(Map<Integer, Double> map) {
        Collection<Double> values = map.values();
        values.add(Constants.RANDOM.nextDouble());
    }

    /**
     * 可以remove 不影响map对象
     *
     * @param map 待操作的map
     */
    public static void removeValues(Map<Integer, Double> map) {
        Collection<Double> values = map.values();
        values.remove(0d);
    }

    public static void addEntrySet(Map<Integer, Double> map) {
        Set<Map.Entry<Integer, Double>> entries = map.entrySet();
        entries.add(new Map.Entry<Integer, Double>() {
            @Override
            public Integer getKey() {
                return null;
            }

            @Override
            public Double getValue() {
                return null;
            }

            @Override
            public Double setValue(Double value) {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        });
    }

    /**
     * 可以remove 不影响map对象
     *
     * @param map 待操作的map
     */
    public static void removeEntrySet(Map<Integer, Double> map) {
        Set<Map.Entry<Integer, Double>> entries = map.entrySet();
        entries.removeIf(integerDoubleEntry -> 0 == integerDoubleEntry.getKey());
    }

}
