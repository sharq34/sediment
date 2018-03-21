package com.marcojan.sediment.algorithm.leetcode;

/**
 * Given an array and a value, remove all instances of that > value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by Marco on 12/04/2017.
 */
public class RemoveElement {

    static int[] array = {2, 3, 7, 6, 5, 4, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        System.out.println(array.length);
        System.out.println(removeSuchValues_optimized(4));
        SedUtil.print(array);

    }


    /**
     * 1. 定义两个游标i和j，i用来遍历数组，当数组中出现符合条件的元素时，j所有元素前移1位
     * 2. 出现两个连续符合条件元素，需要i--，否则正常for循环逻辑会跳过连续元素中的第二个（由于前提一位）
     *
     * @param element 需要移除的元素
     * @return
     */
    static int removeSuchValues(int element) {

        int i = 0, j, sum = array.length;

        for (; i < array.length; i++) {

            if (array[i] == element) {

                //符合IF条件，新数组的长度-1
                --sum;

                //删除当前元素，所有元素前提一位
                j = i;
                while (j < sum) {
                    array[j] = array[++j];
                }

                //最后的坑位补位-1
                array[sum] = -1;

                //因为位置前提导致的连续符合条件元素会漏选掉，i-- 防止连续符合条件的element
                i--;
            }
        }

        return sum;
    }

    /**
     * 1. 建立两个游标i和j，双线程处理这个数组（in place），遍历当前数组按顺序查找值为element的数组的下标，同时递增i和j；
     * 2. 当i等于element的时候，i继续递增，j不变（保持j等于当前element的下标）
     * 3. 当下一个i不等于element的时候，j的位置，替换为当前不等于element的下标i所指的值。
     * @param element
     * @return
     */
    static int removeSuchValues_optimized(int element) {

        int i = 0, j = 0;

        for (; i < array.length; i++) {

            if (array[i] == element) {
                continue;
            }

            array[j]=array[i];
            j++;
        }

        return j;
    }

}
