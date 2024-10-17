package com.marcojan.sediment.algorithm.leetcode;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int consecutiveNumber = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != 0) {
                consecutiveNumber++;
            } else {
                // 前移1位
                int times = consecutiveNumber;
                for (int k = j; times-- > 0; k++) {
                    nums[k] = nums[k + 1];
                    nums[k + 1] = 0;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j] = nums[i];
                if (i!=j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
