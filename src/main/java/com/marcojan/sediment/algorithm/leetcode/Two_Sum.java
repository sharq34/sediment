package com.marcojan.sediment.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {

        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            indices[0] = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == (target - nums[i])) {
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    /**
     * @author: Discussion
     *
     * using map/dict(for python3) to save former interim value and its index.
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Two_Sum ts = new Two_Sum();

        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        int[] indices = ts.twoSum(nums, target);

        System.out.println(indices[0] + " - " + indices[1]);
    }

}
