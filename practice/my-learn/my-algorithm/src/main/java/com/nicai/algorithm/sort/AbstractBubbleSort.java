package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * AbstractBubbleSort-冒泡排序
 * 时间复杂度：
 * 循环次数 * 每次循环的比较次数 = n * ((n-1) + (n-2) + (n-3) + (n-4) + 2 + 1) = n * n/2 = n²/2 = n²
 * 循环次数：n
 * 每次循环的比较次数：(n-1) + (n-2) + (n-3) + (n-4) + 2 + 1
 * 第一次循环：n-1
 * 第二次循环：n-2
 * 第三次循环：n-3
 *
 * @author guozhe
 * @date 2020/08/14
 */
@Slf4j
public abstract class AbstractBubbleSort implements Sort {

    @Override
    public Logger getLogger() {
        return log;
    }

}
