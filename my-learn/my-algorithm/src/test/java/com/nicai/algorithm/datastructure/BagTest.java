package com.nicai.algorithm.datastructure;

import com.nicai.algorithm.datastructure.impl.BagImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * BagTest
 *
 * @author guozhe
 * @date 2020/09/28
 */
@Slf4j
public class BagTest {

    @Test
    public void add() {
        Bag<String> bag = new BagImpl<>();
        Assert.assertTrue(bag.isEmpty());
        for (String str : new String[]{"hello", "my", "first", "stack", "bag"}) {
            bag.add(str);
        }
        Assert.assertFalse(bag.isEmpty());
        Assert.assertEquals(5, bag.size());
        for (String s : bag) {
            log.info(s);
        }
    }
}