package com.andy.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Description: 一个小算法 </p>
 * @author wuqiong  2018年3月22日
 */
public class Solution {

    /**
     * 给定一个整数数组array 和一个整数target，返回数组内2个元素的下标，它们的值满足 相加的和为target。
     * 你可以假定每个输入，都会恰好有一个满足条件的返回结果。
     */
    public static void main(String[] args) {
        double[] nums = {585.36D,
                1285.22D,
                509.88D,
                736.88D,
                583.6D,
                693.79D,
                728.78D,
                659.33D,
                1389.02D,
                817.39D,
                464D,
                617.62D,
                400.81D,
                590.39D,
                380.76D,
                2604.01D,
                1113.23D,
                710.1D,
                1857.71D,
                716.37D,
                1829.85D,
                2078.07D,
                802.21D,
                2295.91D,
                2321.81D,};
        double target = 1164D;

        int[] result = twoSum(nums,target);
        //System.out.println(result);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 方法描述:  时间复杂度O(n)
     * @param nums
     * @param target
     * @return int[]
     * @author wuqiong 2018年3月22日 下午6:09:14
     */
    public static int[] oneSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 方法描述: 时间复杂度O(n^2)
     * @param nums
     * @param target
     * @return int[]
     * @author wuqiong 2018年3月22日 下午6:09:35
     */
    public static int[] twoSum(double[] nums, double target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }


    /**
     * 方法描述: 输入一个数组，给定一个目标值。  求三个任意数相加等于目标值，并返回三个数组内的任意数的 下标值。
     * @param nums
     * @param target
     * @return int[]
     * @author andy 2018年3月22日 下午3:43:51
     */
    public static int[] threeSum(double[] nums,double target){
        int m = 0;
        int[] result = null;
        while (result == null && nums.length > m) {
            if (nums[m] < target) {
                double tar = target - nums[m];
                Map<Double, Integer> map = new HashMap<>();
                for (int j = 0; j < nums.length; j++) {
                    Integer index = map.get(tar - nums[j]);
                    if (index == null) {
                        map.put(nums[j], j);
                    } else {
                        return new int[]{m, j, index};
                    }
                }
            }
            m++;
        }
        return result;
    }




}
