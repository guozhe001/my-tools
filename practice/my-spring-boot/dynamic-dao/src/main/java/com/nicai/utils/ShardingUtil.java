package com.nicai.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author guozhe
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShardingUtil {

    /**
     * 使用2的n次方作为库表的个数，最主要是在后续继续扩展库表时如何把旧数据迁移到新表中
     * 使用2的n次方时可以使用位运算来计算新的库表下标
     */
    static final int DB_NUM = 8;
    static final int TABLE_NUM = 128;

    static final int DB_NUM_HEX = 0x8;
    static final int TABLE_NUM_HEX = 0x80;

    public static int getDbIndex(Long customerId) {
        return Math.toIntExact(customerId % DB_NUM);
    }

    public static int getTableIndex(Long customerId) {
        return Math.toIntExact(customerId % TABLE_NUM);
    }

    public static int getDbIndexBitOperation(Long customerId) {
        return Math.toIntExact(customerId & (DB_NUM_HEX - 1));
    }

    public static int getTableIndexBitOperation(Long customerId) {
        return Math.toIntExact(customerId & (TABLE_NUM_HEX - 1));
    }

}
