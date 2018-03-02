package com.marcojan.sediment.algorithm.leetcode;

public class Max_Sub_Array {

    static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            System.out.println(dp[i - 1]);
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -2, 3, -4, -2, -2, -2, -5, -4};

        System.out.println(maxSubArray(arr));
    }
}
