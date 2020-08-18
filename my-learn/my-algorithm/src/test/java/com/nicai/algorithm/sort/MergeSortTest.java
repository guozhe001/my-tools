package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.stream.IntStream;

/**
 * MergeSortTest
 *
 * @author guozhe
 * @date 2020/08/17
 */
@Slf4j
public class MergeSortTest {

    @Test
    public void merge() throws Exception {
        MergeSort mergeSort = new MergeSort();
        int[] merge = Whitebox.invokeMethod(mergeSort, "merge", new int[]{2, 4, 8}, new int[]{1, 3, 5});
        log.info("merge={}", merge);
        Assert.assertEquals(6, merge.length);
        int[] expect = {1, 2, 3, 4, 5, 8};
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], merge[i]);
        }
    }

    @Test
    public void test() {
        IntStream.range(2, 15).forEach(
                i -> log.info("length = {}, forloop = {},new index={}", i, i / 2 + i % 2, i / 2 + i % 2 - 1)
        );
        Assert.assertTrue(true);
    }

}