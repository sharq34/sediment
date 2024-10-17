package com.marcojan.sediment.algorithm.leetcode;


public class Rotate {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1 ) return;
        if (k >= nums.length) k = k % nums.length;
        int[] numsTemp = new int[k];
        int j = k;
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((j - 1) >= 0)
                numsTemp[j-- - 1] = nums[i];
            if (i - k >= 0)
                nums[i] = nums[i - k];
        }
        System.arraycopy(numsTemp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        new Rotate().rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
