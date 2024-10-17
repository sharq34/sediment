package com.marcojan.sediment.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] key = new char[26];
        for(String s : strs){
            if(s.isEmpty()){
                map.computeIfAbsent(String.valueOf(key), k->new ArrayList<>()).add(s);
                continue;
            }

            for(char c: s.toCharArray()){
                key[c-'a'] += 1;
            }
            map.computeIfAbsent(String.valueOf(key), k->new ArrayList<>()).add(s);
            key = new char[26];
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = new String[]{"ddddddddddg","dgggggggggg"};

        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
            System.out.println("----");
        }
    }
}
