package com.andy.leetCode;

/**
 * <p>@Author wuqiong  2022/1/8 </p>
 */
public class Clockwise {


    public static void main(String[] args) {

        /**
         * 题目:  给定一个矩阵，要求顺时针依次打印出矩阵内的数字
         * 如:
         *      1   2   3   4   5
         *      6   7   8   9   10
         *      11  12  13  14  15
         *      16  17  18  19  20
         *      21  22  23  24  25
         *
         * 依次打印后:  1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6, 7,8,9,14,19,18,17,12,13
         *
         */

        // 假设矩阵是个 二维数组
        int n = 6;
        int[][] nums = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = count++;
            }
        }

        output(nums, 0, n);
    }


    public static void output(int[][] nums, int start, int end) {

        if (start > end && end >= 0) {
            return;
        }
        // 依次打印 每一行 或者 每一列
        for (int i = start; i < end; i++) {
            System.out.print(nums[start][i] + "   ");
        }

        // 最后一纵列
        for (int i = start + 1; i < end; i++) {
            System.out.print(nums[i][end - 1] + "   ");
        }

        // 最后一行
        for (int i = end - 2; i >= start; i--) {
            System.out.print(nums[end - 1][i] + "   ");
        }

        // 正面第一列
        for (int i = end - 2; i > start; i--) {
            System.out.print(nums[i][start] + "   ");
        }
        output(nums, start + 1, end - 1);
    }


}
