package com.nicai.algorithm.other;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author guozhe
 * @date 2023/3/22
 */
public class SumTwo {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = find(numbers, target);
        if (Objects.isNull(ints)) {
            System.out.println("can not find");
        } else {
            System.out.println("result:" + ints[0] + " " + ints[1]);
        }
    }

    private static int[] find(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            // 以数字为key，下标为value，设置map
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int n = target - numbers[i];
            if (map.containsKey(n)) {
                return new int[]{i, map.get(n)};
            }
        }

        return null;
    }
}
