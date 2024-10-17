package com.marcojan.sediment.algorithm.leetcode;

import java.util.Collections;

import static java.lang.System.out;

public class MergeDoubleArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        new MergeDoubleArray().merge(nums1, 3, nums2, 3);
        Collections.singletonList(nums1).forEach(out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[m - 1];
                m--;
            } else {
                nums1[index--] = nums2[n - 1];
                n--;
            }
        }
    }
}
