package com.andy.leetCode;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2022/1/8 </p>
 */
public class FindSum {


    public static void main(String[] args) {
        /**
         * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
         *
         *
         *
         */

        int[] nums = {1,2,2,3,4,5,6,7,8,9};
        int sum = 7;
        find(nums,sum);


    }

    public static void find(int[] nums , int sum ){
        /***
         * 核心思想:
         *   1、先做一个 左右坐标值，
         *   2、从左开始轮询，值并相加，如果小于 目标值就继续轮询， 如果大于则 将左标跳出并加1
         *
         *
         *
         */

        int left = 0 , right = 0 ;

        for (int i = 0; i < nums.length; i++) {
            left = i ;
            right = i;

            int count = 0;
            while (count < sum){
                count += nums[right];
                right ++ ;

            }

            if (count == sum){
                for (int j = left; j < right; j++) {
                    System.out.print(nums[j] + "   "  );
                }
                System.out.println();
//                break;
            }



        }




    }


}
