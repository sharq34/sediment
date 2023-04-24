package com.marcojan.sediment.mq.activemq;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */
public class Test1 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = new Test1().test(coins, amount);
        System.out.println(result);
    }

    public int test(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] temp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            for (int k : coins) {
                if (i - k >= 0) {
                    temp[i] = Math.min(temp[i - k] + 1,temp[i]);
                }
            }
        }
        System.out.println(temp);

        return temp[amount];
    }
}
