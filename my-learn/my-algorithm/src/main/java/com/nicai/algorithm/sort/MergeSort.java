package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

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
            numsArray[i] = new int[]{nums[i]};
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
            } else {
                newNumsArray[i] = merge(numsArray[i * 2], numsArray[nextIndex]);
            }
        }
        return mergeSort(newNumsArray);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] newNums = new int[nums1Length + nums2Length];
        int nums1Index = 0;
        int nums2Index = 0;
        while (nums1Index < nums1Length || nums2Index < nums2Length) {
            // 如果第一个数组已经全部使用
            if (nums1Index == nums1Length) {
                for (int i = nums2Index; i < nums2Length; i++) {
                    newNums[nums1Length + nums2Index] = nums2[nums2Index];
                }
                break;
            }
            if (nums2Index == nums2Length) {
                for (int i = nums1Index; i < nums1Length; i++) {
                    newNums[nums2Length + nums1Index] = nums1[nums1Index];
                }
                break;
            }
            if (nums1[nums1Index] < nums2[nums2Index]) {
                newNums[nums1Index + nums2Index] = nums1[nums1Index];
                nums1Index++;
            } else {
                newNums[nums1Index + nums2Index] = nums2[nums2Index];
                nums2Index++;
            }
        }
        return newNums;
    }

    @Override
    public String getName() {
        return "归并排序";
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
