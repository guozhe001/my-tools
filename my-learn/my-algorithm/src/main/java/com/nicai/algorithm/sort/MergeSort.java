package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.stream.IntStream;

/**
 * MergeSort，归并排序
 *
 * @author guozhe
 * @date 2020/08/17
 */
@Slf4j
public class MergeSort implements Sort {


    @Override
    public int[] sort(int[] nums) {
        // 拆分数组，每个数字为一个单独的数组
        int[][] numsArray = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            numsArray[0] = new int[]{nums[0]};
        }
        return mergeSort(numsArray)[0];
    }

    private int[][] mergeSort(int[][] numsArray) {
        if (numsArray.length <= 1) {
            return numsArray;
        }
        int[][] newNumsArray = new int[numsArray.length / 2 + numsArray.length % 2][];
        for (int i = 0; i < newNumsArray.length; i++) {
            int nextIndex = i * 2 + 1;
            if (nextIndex >= numsArray.length) {
                newNumsArray[i] = numsArray[i * 2];
            }
            merge(numsArray[i * 2], numsArray[i * 2 + 1]);
        }
        return mergeSort(newNumsArray);
    }

    private void merge(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int nums1Index = 0;
        int nums2Index = 0;
        // 如果nums1里面的数字已经取完
        if (nums1Index == nums1.length-1){
            for (int i = ; i < ; i++) {

            }
        }
    }

    @Override
    public String getName() {
        return "归并排序";
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    public static void main(String[] args) {
        IntStream.range(2, 15).forEach(
                i -> log.info("length = {}, forloop = {},new index={}", i, i / 2 + i % 2, i / 2 + i % 2 - 1)
        );
    }
}
