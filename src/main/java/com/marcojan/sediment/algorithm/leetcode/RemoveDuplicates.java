package com.marcojan.sediment.algorithm.leetcode;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Given a sorted array, remove the duplicates in place such that > each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * <p>
 * Created by Marco on 13/04/2017.
 */
public class RemoveDuplicates {

    static int[] array = {1, 1, 1, 1, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 10, 11, 11, 11, 12, 13};

    public static void main(String[] args) {
//        System.out.println(array.length);
//        System.out.println(removeDuplicatesAtMost2());
        keepUnique();
        System.out.println(array);
    }


    /**
     * 已排序的数组，应该从小到大各不相同。
     * <p>
     * 推断：array[i]不应等于array[i+1]
     * <p>
     * 用两个游标i和j来遍历数组，j=0, i=1; i=j+1
     * 如果array[j]!=array[i]，也就是说数组的前一个和后一个不相同，
     * 那么，就把array[j+1]设置为array[i]，这步操作对于没有出现重复数据的两个节点是重复操作，因为本身i=j+1，做了重复的赋值。
     * 如果，前后两个值相同，那么i++，j不变，等找到那个不同的时候array[++j]=array[i]。
     *
     * @return
     */
    static int removeDuplicates() {


        int i = 1, j = 0;

        for (; i < array.length; i++) {

            if (array[i] != array[j]) {
                array[++j] = array[i];
            }
        }

        return j + 1;
    }


    /**
     * SQL
     */

    /**
     * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
     * <p>
     * For example, Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3].
     */
    static int removeDuplicatesAtMost2() {

        int i = 1, j = 0, k = 1;

        for (; i < array.length; i++) {

            if (array[i] != array[j]) {

                array[++j] = array[i];
                k = 1;

            } else if (array[i] == array[j] && k == 2) {
                continue;
            } else if (array[i] == array[j] && k == 1) {
                array[++j] = array[i];
                k++;
            }

        }

        return j + 1;
    }

    // remove duplicates 20230425
    static void keepUnique() {

        for (int i = 0; i < array.length; i++) {
            int std = array[i];
            // the end todo
            if (i == array.length - 1) break;
            int offset = 0;
            for (int j = i + 1; j < array.length; j++) {
                int tar = array[j];
                if (std == tar) {
                    offset++;
                } else {
                    break;
                }
            }
            if (offset != 0)
                rebuild(i, offset);
        }
    }

    static void rebuild(int idx, int offset) {
        for (int i = idx + 1; i < array.length; i++) {
            array[i] = array[i + offset];
        }
    }
}
