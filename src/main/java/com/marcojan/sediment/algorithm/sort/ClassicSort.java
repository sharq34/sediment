package com.marcojan.sediment.algorithm.sort;

import com.marcojan.sediment.common.SedUtil;

/**
 * Created by Marco on 10/04/2017.
 */
public class ClassicSort {

    static int[] unsorted = {3, 10, 9, 7, 8, 4, 2, 12, 11, 5, 14, 13, 6, 1};

    public static void main(String[] args) {
//        new SortSample().bubbleSort();
//        new SortSample().selectedSort();

//        new SortSample().quickSort(0, unsorted.length - 1, unsorted);
//        new SortSample().print();

        new ClassicSort().insert();
    }


    public void bubbleSort() {

        for (int i = 0; i < unsorted.length; i++) {

            for (int j = 0; j < unsorted.length - i - 1; j++) {

                if (unsorted[j] > unsorted[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }

        SedUtil.print(unsorted);
    }

    public void selectedSort() {

        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {
                    swap(i, j);
                }
            }
        }

        SedUtil.print(unsorted);
    }

    public void quickSort(int beg, int end, int[] unsorted) {

        if (beg < end) {

            int pivotal = unsorted[beg];

            int i = beg;
            int j = end;

            while (i < j) {

                while (j > i && unsorted[j] > pivotal)
                    j--;

                if (pivotal > unsorted[j])
                    unsorted[i++] = unsorted[j];


                while (i < j && unsorted[i] < pivotal)
                    i++;

                if (unsorted[i] > pivotal)
                    unsorted[j--] = unsorted[i];

            }

            unsorted[i] = pivotal;

            quickSort(beg, i - 1, unsorted);
            quickSort(i + 1, end, unsorted);
        }

    }

    //static int[] unsorted = {3, 10, 9, 7, 8, 4, 2, 12, 11, 5, 14, 13, 6, 1};
    private void insert() {

        for (int i = 1; i < unsorted.length; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if (unsorted[i] < unsorted[j]) {

                    int k = i;
                    int temp = unsorted[i];

                    while (k > 0 && temp < unsorted[k - 1]) {
                        unsorted[k] = unsorted[--k];
                    }
                    unsorted[k] = temp;
                    break;
                }
            }
        }

        SedUtil.print(unsorted);

    }

    private void swap(int index1, int index2) {
        int temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }

}
