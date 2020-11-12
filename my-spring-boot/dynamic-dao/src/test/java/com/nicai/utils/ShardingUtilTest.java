package com.nicai.utils;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ShardingUtilTest {

    private static final Random r = new Random(7);

    private static final int count = 1000000;
    private static final Long[] customers = new Long[count];

    @BeforeClass
    public static void init() {
        for (int i = 0; i < count; i++) {
            customers[i] = Math.abs(r.nextLong());
        }
    }

    /**
     * 测试
     */
    @Test
    public void compare() {
        Arrays.stream(customers).forEach(i -> invokeAndPrint(Math.abs(r.nextLong())));
    }

    /**
     * 效率测试
     */
    @Test
    public void efficiency() {
        Stopwatch started = Stopwatch.createStarted();
        Arrays.stream(customers).forEach(customerId -> {
            ShardingUtil.getDbIndex(customerId);
            ShardingUtil.getTableIndex(customerId);
        });
        log.info("求余运算【{}】次,花费时间【{}】MILLISECONDS", count, started.elapsed(TimeUnit.MILLISECONDS));
        Stopwatch reset = started.reset().start();
        Arrays.stream(customers).forEach(customerId -> {
            ShardingUtil.getDbIndexBitOperation(customerId);
            ShardingUtil.getTableIndexBitOperation(customerId);
        });
        log.info("按位运算【{}】次,花费时间【{}】MILLISECONDS", count, reset.elapsed(TimeUnit.MILLISECONDS));
    }

    /**
     * 测试位运算与取余数元算的结果是否相等
     *
     * @param customerId
     */
    private void invokeAndPrint(Long customerId) {
        int dbIndex = ShardingUtil.getDbIndex(customerId);
        int tableIndex = ShardingUtil.getTableIndex(customerId);
        int dbIndexBO = ShardingUtil.getDbIndexBitOperation(customerId);
        int tableIndexBO = ShardingUtil.getTableIndexBitOperation(customerId);

        Assert.assertEquals(dbIndex, dbIndexBO);
        Assert.assertEquals(tableIndex, tableIndexBO);
    }

    @Test
    public void test() {
        Assert.assertEquals(ShardingUtil.DB_NUM, ShardingUtil.DB_NUM_HEX);
    }

    @Test
    public void test2() {
        Assert.assertEquals(ShardingUtil.TABLE_NUM, ShardingUtil.TABLE_NUM_HEX);
    }

    @Test
    public void a() {
        int num = 104;
        log.info("num={}, result={}", num, num % 8);
    }
}