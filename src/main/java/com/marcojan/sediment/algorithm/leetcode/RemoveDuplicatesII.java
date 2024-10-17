package com.marcojan.sediment.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int length = new RemoveDuplicatesII().removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
