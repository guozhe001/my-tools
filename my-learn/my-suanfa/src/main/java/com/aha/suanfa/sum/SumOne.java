package com.aha.suanfa.sum;

import java.util.Arrays;

/**
 * 数组相加：把传入的一个数组的的各个值相加并作为结果返回
 * <p>
 * 使用D&C思想
 * 1、基准条件是什么？
 * 数组中只有一个值，则直接返回这个值
 * 数组中没有值，则直接返回0
 *
 * @author guozhe
 */
public class SumOne implements Sum {

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
        // 如果数组中有两个值，则返回两数只和
        if (nums.length == 2) {
            return nums[0] + nums[1];
        }
        // 其他情况，把数组切分，第一个数组是前两个数字，第二个数组是后面的所有的数字
        return sum(Arrays.copyOfRange(nums, 0, 2)) + sum(Arrays.copyOfRange(nums, 2, nums.length));
    }

}
