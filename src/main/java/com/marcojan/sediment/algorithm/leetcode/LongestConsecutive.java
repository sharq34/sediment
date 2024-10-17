package com.marcojan.sediment.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet hs = new HashSet();
        for (int num : nums) {
            hs.add(num);
        }

        AtomicInteger longConsecutive = new AtomicInteger();

        hs.forEach(v -> {
            if (!hs.contains((Integer) v - 1)) {
                int current = ((Integer) v).intValue();
                int consecutive = 1;

                while (hs.contains(current + 1)) {
                    consecutive++;
                    current++;
                }

                longConsecutive.set(Math.max(longConsecutive.get(), consecutive));
            }
        });

        return longConsecutive.intValue();
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));
    }
}
