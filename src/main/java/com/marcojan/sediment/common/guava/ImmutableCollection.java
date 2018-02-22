package com.marcojan.sediment.common.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by yangyang6 on 6/27/2017.
 */
public class ImmutableCollection {

    public static void main(String[] args) {

        HashMap hm = Maps.newHashMapWithExpectedSize(1);

        hm.put(1,2);
        hm.put(3,4);

        System.out.println(hm.size());

        ImmutableMap immutableMap = ImmutableMap.copyOf(hm);

        hm.put(5,6);
        System.out.println(hm.size());

        System.out.println(immutableMap.size());

    }
}
