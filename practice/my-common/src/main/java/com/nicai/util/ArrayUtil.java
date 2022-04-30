package com.nicai.util;

import com.google.common.collect.Maps;
import com.nicai.exception.NicaiException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020/08/19
 */
public class ArrayUtil {
    private ArrayUtil() {
        throw new NicaiException();
    }

    /**
     * 随机类
     */
    private static final Random random = new Random();

    /**
     * 生成一个长度为length，值为不超过数组长度的随机数的数组
     *
     * @param length 需要生成的数组长度
     * @return 数组
     */
    public static int[] randomIntArray(final int length) {
        int[] result = new int[length];
        IntStream.range(0, length).forEach(i -> result[i] = random.nextInt(length));
        return result;
    }

    /**
     * 生成一个长度小于length，值为[0,length)的数组，数字的顺序随机的数组
     *
     * @param length 需要生成的数组长度
     * @return 数组
     */
    public static int[] randomNotRepeatIntArray(final int length) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        int[] initArray = randomIntArray(length);
        int[] tempArray = new int[initArray.length];
        int index = 0;
        for (int num : initArray) {
            // 如果不包含此key，说明此数字不重复
            if (!map.containsKey(num)) {
                map.put(num, num);
                tempArray[index] = num;
                index++;
            }
        }
        return Arrays.copyOfRange(tempArray, 0, index);
    }

    public static <T> boolean isSorted(Comparable<T>[] comparables) {
        for (int i = 0; i < comparables.length - 1; i++) {
            if (comparables[i].compareTo((T) comparables[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
