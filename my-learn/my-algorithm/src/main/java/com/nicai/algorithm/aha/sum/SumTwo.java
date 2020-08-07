package com.nicai.algorithm.aha.sum;

import java.util.Arrays;

public class SumTwo implements Sum {

    @Override
    public int sum(int[] nums) {
        // 如果数组中没有值，则直接返回0
        if (nums.length == 0) {
            return 0;
        }
        // 如果数组只有一个值，则直接返回数组中唯一的那个值
        if (nums.length == 1) {
            return nums[0];
        }
        // 其他情况，把数组切分，第一个数组是前两个数字，第二个数组是后面的所有的数字
        return nums[0] + sum(Arrays.copyOfRange(nums, 1, nums.length));
    }
}
