package com.marcojan.sediment.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPermutationDifference {

    public int findPermutationDifference(String s, String t) {
        List<Character> cs = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> ct = t.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Map<Character, Integer> sMap = IntStream.range(0, cs.size())
                .boxed()
                .collect(Collectors.toMap(cs::get, i -> i));

        Map<Character, Integer> tMap = IntStream.range(0, ct.size())
                .boxed()
                .collect(Collectors.toMap(ct::get, i -> i));

        return sMap.entrySet().stream().map(e ->
                Math.abs(e.getValue() - tMap.get(e.getKey()))
        ).reduce(0, (a, b) -> a + b);

    }
}
