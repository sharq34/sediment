package com.marcojan.sediment.algorithm.leetcode;

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        // 1. 计算数组和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0)
            return false;

        // 2. 计算子集和
        int target = sum / k;
        return false;
    }
}
