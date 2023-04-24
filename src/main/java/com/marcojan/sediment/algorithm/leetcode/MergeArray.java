package com.marcojan.sediment.algorithm.leetcode;

public class MergeArray {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new MergeArray().merge(intervals);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " - " + result[i][1]);
        }
    }

    private int[][] merge(int[][] arrays) {

        int[][] result = new int[arrays.length][2];
        int r = 0;
        result[0][0] = arrays[0][0];

        for (int i = 0; i < arrays.length; i++) {

            if (i + 1 == arrays.length) {
                if (result[r][0] == 0)
                    result[r][0] = arrays[i][0];
                result[r][1] = arrays[i][1];
                break;
            }

            if (arrays[i][1]>=arrays[i + 1][0]){
                result[r][1] = arrays[i + 1][1];
                result[r + 1][0] = arrays[i + 1][0];
            }else{
                result[r][0] = arrays[i][0];
                result[r][1] = arrays[i][1];
                r++;
            }
        }

        return result;
    }
}

