package com.nicai.experience.p3c.collection;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author guozhe
 * @date 2020-04-28
 */
public class CollectionToMapTest {

    private static final List<CollectionToMap.Pair> PAIRS = Lists.newArrayList();

    private static final Random random = new Random();

    private static final String KEY1 = "version1";
    private static final String KEY2 = "version2";
    private static final String KEY3 = "version3";

    @BeforeClass
    public static void initList() {
        PAIRS.clear();
        PAIRS.add(new CollectionToMap.Pair(KEY1, random.nextDouble()));
        PAIRS.add(new CollectionToMap.Pair(KEY2, random.nextDouble()));
        PAIRS.add(new CollectionToMap.Pair(KEY2, random.nextDouble()));
    }

    /**
     * 有重复的key报异常java.lang.IllegalStateException: Duplicate key 0.7533624347436513
     */
    @Test(expected = IllegalStateException.class)
    public void collectToMapDuplicateKey() {
        CollectionToMap.collectToMap(PAIRS);
    }

    /**
     * 没有重复的key并且value没有为null的数据转换正常
     */
    @Test
    public void collectToMap() {
        List<CollectionToMap.Pair> myPairs = Lists.newArrayList(PAIRS);
        myPairs.remove(2);
        Map<String, Double> stringDoubleMap = CollectionToMap.collectToMap(myPairs);
        Assert.assertEquals(2, stringDoubleMap.size());
        Assert.assertTrue(stringDoubleMap.containsKey(KEY1));
        Assert.assertTrue(stringDoubleMap.containsKey(KEY2));
    }

    /**
     * 没有重复的key，但是value存在null值
     */
    @Test(expected = NullPointerException.class)
    public void collectToMapNullValue() {
        List<CollectionToMap.Pair> myPairs = Lists.newArrayList(PAIRS);
        myPairs.remove(2);
        myPairs.add(new CollectionToMap.Pair(KEY3, null));
        CollectionToMap.collectToMap(myPairs);
    }

    /**
     * 有重复的key,
     */
    @Test
    public void collectToMapMergeDuplicateKeyHaveDuplicateKey() {
        Map<String, Double> stringDoubleMap = CollectionToMap.collectToMapMergeDuplicateKey(PAIRS);
        Assert.assertEquals(2, stringDoubleMap.size());
        Assert.assertTrue(stringDoubleMap.containsKey(KEY1));
        Assert.assertTrue(stringDoubleMap.containsKey(KEY2));
    }

    /**
     * 没有重复的key，转换正常
     */
    @Test
    public void collectToMapMergeDuplicateKey() {
        List<CollectionToMap.Pair> myPairs = Lists.newArrayList(PAIRS);
        myPairs.remove(2);
        Map<String, Double> stringDoubleMap = CollectionToMap.collectToMapMergeDuplicateKey(myPairs);
        Assert.assertEquals(2, stringDoubleMap.size());
        Assert.assertTrue(stringDoubleMap.containsKey(KEY1));
        Assert.assertTrue(stringDoubleMap.containsKey(KEY2));
    }

    /**
     * 没有重复的key，但是value存在null值
     */
    @Test(expected = NullPointerException.class)
    public void collectToMapMergeDuplicateKeyNullValue() {
        List<CollectionToMap.Pair> myPairs = Lists.newArrayList(PAIRS);
        myPairs.remove(2);
        myPairs.add(new CollectionToMap.Pair(KEY3, null));
        CollectionToMap.collectToMapMergeDuplicateKey(myPairs);
    }

}