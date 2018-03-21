package com.marcojan.sediment.algorithm.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * PINTEC面试题 @20180315
 * <p>
 * 实现一个函数，入参 N，生成一个数组，长度为 N-1，数组里的元素各不相同。
 * <p>
 * for example:
 * <p>
 * genArray(int n)
 * <p>
 *
 * @Reference https://www.cnblogs.com/eaglet/archive/2011/01/17/1937083.html
 *
 * Created by Marco on 16/03/2018.
 */
public class GenRandomArray {

    /**
     * 空间复杂度高，维护了一个 ArrayList
     */
    static int[] genArray0(int n) {

        long start = System.currentTimeMillis();

        int[] array = new int[n];
        List<Integer> list = new ArrayList(n);

        int i = 0;
        for (; i < n; i++)
            list.add(i);

        for (int j = 0; j < n; j++) {

            int length = list.size();

            Random r = new Random();
            int index = r.nextInt(length);

            array[j] = list.remove(index);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        return array;
    }

    /**
     * 时间复杂度高，最后想获得 hashtable[index] == 0 的值，需要多次尝试
     */
    static int[] genArray1(int n) {

        long start = System.currentTimeMillis();

        int[] array = new int[n];
        int[] interim = new int[n];

        Random r = new Random();
        int times = 0;

        for (int i = 0; i < n; i++) {

            int index = r.nextInt(n);

            while (interim[index] > 0) {
                index = r.nextInt(n);
                times++;
            }

            array[i] = index;
            interim[index] = 1;
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        return array;
    }


    /**
     * ArrayList remove 会从新 re-index 数组里的元素
     * so, remove -> swap
     */
    static int[] genArray2(int n) {

        long start = System.currentTimeMillis();

        int[] array = new int[n];
        int[] interim = new int[n];

        int i = 0;
        for (; i < n; i++)
            interim[i] = i;

        Random random = new Random();

        for (int j = 0; j < n; j++) {
            int index = random.nextInt(n - j);
            array[j] = interim[index];
            interim[index] = interim[n - j - 1];
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        return array;
    }


    public static void main(String[] args) {

        int n = 100000;

        genArray0(n);
        genArray1(n);
        genArray2(n);

//        for (int i : genArray2(n))
//            System.out.println(i + ", ");
    }
}
