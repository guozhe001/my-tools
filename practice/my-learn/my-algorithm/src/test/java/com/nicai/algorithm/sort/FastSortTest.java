package com.nicai.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.stream.IntStream;

/**
 * FastSortTest
 *
 * @author guozhe
 * @date 2020/08/18
 */
public class FastSortTest {

    @Test
    public void merge() throws Exception {
        int[] newArray = Whitebox.invokeMethod(new FastSort(), "merge", new int[]{1, 2, 3}, new int[]{4}, new int[]{5, 6, 7, 8});
        Assert.assertEquals(8, newArray.length);
        IntStream.range(0, 8).forEach(i -> Assert.assertEquals(i + 1, newArray[i]));
    }

    @Test
    public void mergeAllEmpty() throws Exception {
        int[] newArray = Whitebox.invokeMethod(new FastSort(), "merge", new int[]{}, new int[]{}, new int[]{});
        Assert.assertEquals(0, newArray.length);
    }

    @Test
    public void mergeOneEmpty() throws Exception {
        int[] newArray = Whitebox.invokeMethod(new FastSort(), "merge", new int[]{1, 2, 3}, new int[]{4}, new int[]{});
        Assert.assertEquals(4, newArray.length);
        IntStream.range(0, 4).forEach(i -> Assert.assertEquals(i + 1, newArray[i]));
    }

}