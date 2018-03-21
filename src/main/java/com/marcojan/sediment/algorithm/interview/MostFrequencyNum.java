package com.marcojan.sediment.algorithm.interview;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 思路:  该数组排序以后，出现次数大于长度的数一定是他的中位数。
 *
 */
public class MostFrequencyNum {

    /**
     * 随便找一个数作为参照数, 记出现次数 times = 1
     * 从最开始开始遍历, 如果下一个数和他相同，那么times++, 如果不同times--
     * times == 0 更换参照数为当前数
     *
     * 复杂度O(n)
     *
     * @param arr
     * @return
     */
    static int findMostFrequencyNumber(int[] arr) {

        int interim = arr[arr.length - 1];
        int times = 1;

        for (int current : arr) {

            if (current == interim) {
                times++;
                continue;
            } else {
                times--;
            }

            if (times == 0) {
                interim = current;
                times = 1;
            }
        }

        return interim;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 5, 5, 5, 4, 1, 5, 1, 5};
        System.out.println(findMostFrequencyNumber(arr));
    }
}
