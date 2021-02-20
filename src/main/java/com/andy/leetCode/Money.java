package com.andy.leetCode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>Description: 找零钱 - 动态规划 </p>
 * <p>@Author wuqiong  2020/12/14 </p>
 */
public class Money {


    /**
     * 找零钱 - 动态规划
     * 给定数组arr，arr中所有的值都为正数且不重复。
     * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
     * 在给定一个整数target代表要找的钱数，求: 还(huan)钱有多少种方法
     */


    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date.getTime());
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("tstdate",new Date(1608277649240L));
        jsonObject.put("date", date);

        String replace = jsonObject.toJSONString().replace("a", "s");

        System.out.println(jsonObject.toJSONString());

        int[] moneyArray = {1, 2, 5, 7, 10};

        int target = 13;

        System.out.println(Change2(moneyArray, target));


    }


    public static int Change(int[] moneys, int target) {
        /**
         * 首先思路就是 ， 将数组内每个面值的钱， 找到对应的可分解的最优数量， 初始默认全都是 -1
         * 然后用目标值去 寻找可以分解的最优(最少)数量
         */

        // 定义 target值的数组
        int[] targetArray = new int[target + 1];
        targetArray[0] = 0;
        for (int i = 1; i < targetArray.length; i++) {
            targetArray[i] = -1;
        }
        // 依次计算 从 1 到 target 的最优解
        for (int i = 1; i <= target; i++) {

            // 对于每个金额 i， 使用变量j 遍历面值数组
            for (int j = 0; j < moneys.length; j++) {
                // 所有小于等于 i 面值的 targetArray ，如果金额 i - moneys[j] 有最优解
                if (moneys[j] <= i && targetArray[i - moneys[j]] != -1) {

                    if (targetArray[i] == -1 || targetArray[i] > targetArray[i - moneys[j]] + 1) {
                        targetArray[i] = targetArray[i - moneys[j]] + 1;
                    }
                }
            }

        }
        return targetArray[target];
    }


    public static int Change2(int[] moneys, int target) {

        // 修改一下内容
        int[] arr = new int[target + 1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < moneys.length; j++) {
                // 面值必须小于 当前金额 i  ，  并且当前面值i  减去 当前的金额 不等于负1
                if (moneys[j] <= i && arr[i - moneys[j]] != -1) {

                    // 当前面值找零是负1 ，表示没有设置过值 ,或者说 当前金额为进行计算
                    // arr[i] 里面的值 比正在计算的最优解  大 ，则修改arr[i] 的值为 正在计算的值
                    if (arr[i] == -1 || arr[i] > arr[i - moneys[j]] + 1) {

                        arr[i] = arr[i - moneys[j]] + 1;
                    }
                }
            }

        }


        System.out.println(Arrays.toString(arr));


        return 0;
    }


}



