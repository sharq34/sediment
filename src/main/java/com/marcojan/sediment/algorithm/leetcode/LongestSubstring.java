package com.marcojan.sediment.algorithm.leetcode;

public class LongestSubstring {

    public static void main(String[] args) {
        int length = new LongestSubstring().lengthOfLongestSubstring("hkcpmprxxxqw");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {

        if("".equals(s))
            return 0;

        int max = 1;
        StringBuilder substring = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (substring.indexOf(String.valueOf(s.charAt(i))) == -1) {
                substring.append(s.charAt(i));

                System.out.println(substring+" - "+substring.length());

                if (i + 1 == s.length() && substring.length() > max)
                    max = substring.length();

            } else {

                if (substring.length() >= max) {
                    max = substring.length();
                }
                substring = substring.delete(0, substring.indexOf(String.valueOf(s.charAt(i)))+1).append(s.charAt(i));
            }
        }

        return max;
    }
}
