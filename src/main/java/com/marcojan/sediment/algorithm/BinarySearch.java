package com.marcojan.sediment.algorithm;

/**
 * 二分查找法
 *
 * 缩小查询范围: 取中, 判断大小, 定位到左区或者右区
 */
public class BinarySearch {

    static int binary_search(int[] array, int key, int start, int end) {

        if (start > end) return -1;

        // 取中数，需要 (start + end) / 2
        int mid = start + ((end - start) >> 1);

        if (key == array[mid])
            return mid;

        if (key < array[mid])
            return binary_search(array, key, 0, mid - 1);
        else
            return binary_search(array, key, mid + 1, end);
    }

    static int binary_search_X_recursion(int[] array, int key) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + ((end - start) >> 1);

            if (key == array[mid])
                return mid;

            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个与key相同的值的下标
     * <p>
     * if key <= array[mid], 就可以把end变更为mid-1, 舍弃掉后面相等部分
     */

    static int binary_search_first_value(int[] array, int key) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + ((end - start) >> 1);
            //System.out.println(start + " - " + end + " - " + mid);

            if (key <= array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start <= (array.length - 1) && array[start] == key)
            return start;

        return -1;
    }

    /**
     * 查找最后一个与key相同的值的下标
     * <p>
     * if key >= array[mid], 就可以把start变更为mid+1, 舍弃掉前面相等部分
     */
    static int binary_search_last_value(int[] array, int key) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + ((end - start) >> 1);
            //System.out.println(start + " - " + end + " - " + mid);

            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (end <= (array.length - 1) && array[end] == key)
            return end;

        return -1;
    }


    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int key1 = 71;

        System.out.println("index_recursion: " + binary_search(array1, key1, 0, array1.length - 1));
        System.out.println("index_X_recursion: " + binary_search_X_recursion(array1, key1));


        int[] array2 = {1, 2, 3, 3, 3};
        int key2 = 3;

        System.out.println("binary_search_first_value: " + binary_search_first_value(array2, key2));
        System.out.println("binary_search_last_value: " + binary_search_last_value(array2, key2));
    }
}
