package com.marcojan.sediment.algorithm.leetcode;

public class MinimumAverage {

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,3,4,15,13,4,1};
        System.out.println(new MinimumAverage().minimumAverage(nums));
    }

    public double minimumAverage(int[] nums) {
        sort(nums);
        double minimum = (double) (nums[0] + nums[nums.length - 1]) / 2;
        double[] average = new double[nums.length / 2];
        for (int i = 0; i < average.length; i++) {
            average[i] = (double) (nums[i] + nums[nums.length - 1 - i]) / 2;
            if(minimum>average[i]){
                minimum = average[i];
            }
        }

        for (int i = 0; i < average.length; i++) {
            System.out.println(average[i]);
        }

        return minimum;
    }

    void sort(int[] nums) {
        // 冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
