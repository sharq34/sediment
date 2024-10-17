package com.marcojan.sediment.algorithm.leetcode;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {

            if (buy > prices[i]) {
                buy = prices[i];
                continue;
            }


            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }
}
