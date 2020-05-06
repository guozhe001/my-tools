package com.nicai.experience.p3c.chapterone.fourth;

import com.google.common.collect.Maps;
import com.nicai.experience.p3c.chapterone.sixth.MapKeySet;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.nicai.experience.constans.MyConstant.RANDOM;

/**
 * @author guozhe
 * @date 2020-04-28
 */
@Slf4j
public class MapKeySetTest {

    private static final Map<Integer, Double> MAP = Maps.newHashMap();

    @BeforeClass
    public static void initMap() {
        MAP.clear();
        MAP.put(RANDOM.nextInt(), RANDOM.nextDouble());
        MAP.put(RANDOM.nextInt(), RANDOM.nextDouble());
        MAP.put(RANDOM.nextInt(), RANDOM.nextDouble());
        MAP.put(RANDOM.nextInt(), RANDOM.nextDouble());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addKeySet() {
        MapKeySet.addKeySet(MAP);
    }

    @Test
    public void removeKeySet() {
        log.info("=========start==========");
        print(MAP);
        log.info("===================");
        MapKeySet.removeKeySet(MAP);
        print(MAP);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addValues() {
        MapKeySet.addValues(MAP);
    }

    @Test
    public void removeValues() {
        log.info("=========start==========");
        print(MAP);
        log.info("===================");
        MapKeySet.removeValues(MAP);
        print(MAP);
    }

    private void print(Map<Integer, Double> map) {
        map.forEach((k, v) -> log.info("k={},v={}", k, v));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void modifyEntrySet() {
        MapKeySet.addEntrySet(MAP);
    }

    @Test
    public void removeEntrySet() {
        log.info("=========start==========");
        print(MAP);
        log.info("===================");
        MapKeySet.removeEntrySet(MAP);
        print(MAP);
    }

}