package com.nicai.algorithm.search;

import com.google.common.collect.Lists;
import com.nicai.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
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

    private static final List<Search> TO_BE_TEST_LIST = Lists.newArrayList(
//            new BinarySearch(),
            new LinearSearch()
    );

    @Test
    public void searchHaveValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            log.info("nums={}", nums);
            int expectIndex = random.nextInt(nums.length);
            int searchValue = nums[expectIndex];
            log.info("searchValue={}, expectIndex={}", searchValue, expectIndex);
            TO_BE_TEST_LIST.forEach(search -> {
                Optional<Integer> optionalInteger = search.search(nums, searchValue);
                Assert.assertTrue(optionalInteger.isPresent());
                Assert.assertEquals(Integer.valueOf(expectIndex), optionalInteger.get());
            });
        });
    }

    @Test
    public void searchNoValue() {
        IntStream.range(0, 10).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(1000);
            TO_BE_TEST_LIST.forEach(search -> {
                Optional<Integer> optionalInteger = search.search(nums, 1000);
                Assert.assertFalse(optionalInteger.isPresent());
            });
        });
    }

}