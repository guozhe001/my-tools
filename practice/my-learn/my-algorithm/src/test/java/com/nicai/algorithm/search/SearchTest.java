package com.nicai.algorithm.search;

import com.nicai.algorithm.sort.FastSort;
import com.nicai.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020/08/19
 */
@Slf4j
public class SearchTest {

    private static final Random random = new Random();

    @Test
    public void linearSearchHaveValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            int expectIndex = random.nextInt(nums.length);
            int searchValue = nums[expectIndex];
            searchAndCheck(new LinearSearch(), nums, searchValue, expectIndex);
        });
    }

    @Test
    public void linearSearchNoValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            searchAndCheck(new LinearSearch(), nums, 1000, null);
        });
    }

    @Test
    public void binarySearchHaveValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            int[] sorted = new FastSort().sort(nums);
            int expectIndex = random.nextInt(sorted.length);
            int searchValue = sorted[expectIndex];
            searchAndCheck(new BinarySearch(), sorted, searchValue, expectIndex);
        });
    }

    @Test
    public void binarySearchNoValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            int[] sorted = new FastSort().sort(nums);
            searchAndCheck(new BinarySearch(), sorted, 1000, null);
        });
    }

    /**
     * 查找并校验是否正确
     *
     * @param search 使用的查找类
     * @param array  待查找的数组
     * @param value  待查找的数值
     * @param expect 期待的数值位置
     */
    private static void searchAndCheck(Search search, int[] array, int value, Integer expect) {
        log.info("array={}", array);
        log.info("search={}, value={}, expect={}", search.getClass().getName(), value, expect);
        Optional<Integer> result = search.search(array, value);
        if (Objects.isNull(expect)) {
            Assert.assertFalse(result.isPresent());
        } else {
            Assert.assertTrue(result.isPresent());
            Assert.assertEquals(expect, result.get());
        }
    }

}