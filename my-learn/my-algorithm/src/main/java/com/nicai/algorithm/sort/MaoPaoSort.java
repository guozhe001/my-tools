package com.nicai.algorithm.sort;

/**
 * MaoPaoSort
 * 冒泡排序：
 * 1、从右向左分别对两个相邻的数字进行比较
 * 2、如果左边的数字大于右边的数字，则位置进行交换
 * 3、直到比较到数组的最左边，并把这一轮的最小的数字换到最左端
 * 4、继续进行1和2步骤的操作，然后第二轮比较到倒数第二位
 * 5、持续以上步骤直到结束
 *
 * @author guozhe
 * @date 2020/08/14
 */
public class MaoPaoSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        // 循环n次
        for (int i = 0; i < nums.length; i++) {
            /*
             * 冒泡排序的规律：
             * 第一次循环比较n-1次
             * 第二次循环比较n-2次
             * 第三次循环比较n-3次
             *
             * 代码循环的规律：
             * i=0时，比较n-1次
             * i=1时，比较n-2次
             * i=2时，比较n-3次
             *
             * 结束比较的规律：
             * i=0时，比较到数组的第0个为止
             * i=1时，比较到数组的第1个为止
             * i=2时，比较到数组的第2个为止
             *
             */
            for (int j = nums.length - 1; j > i; j--) {
                compareAndSwap(nums, j);
            }
        }
        return nums;
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }

    /**
     * 比较指定的下标和此下标前面的的两个数字，如果前面的数字大于当前的数字，则交换位置
     *
     * @param nums  需要比较的数组
     * @param index 指定的下标
     */
    private void compareAndSwap(int[] nums, int index) {
        int currentNum = nums[index];
        int theNumBeforeCurrentNum = nums[index - 1];
        if (currentNum < theNumBeforeCurrentNum) {
            nums[index] = theNumBeforeCurrentNum;
            nums[index - 1] = currentNum;
        }
    }

}
