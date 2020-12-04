package com.andy.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * <p>Description:给定一个数组，算出目标位数 的数值  </p>
 * <p>@author wuqiong  2018/3/26 16:19 </p>
 */
public class LargestElement {

    /**
     * 给出数组 [9,3,2,4,8]，第三大的元素是 4
     * 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
     */
    public static void main(String[] args) {
        // 数组
        int[] nums = {451,8343,15,843,548};
        //返回第 5 大的数字
        int k = 3;
        long start= System.currentTimeMillis();
        int tag = kthLargestElement(k,nums);
        System.out.println("耗时:"+ (System.currentTimeMillis()-start) +"  --   " + tag);

    }


    public static int kthLargestElement(int k, int[] nums) {
        // 给定集合长度，减少扩容次数
        HashSet<Integer> map=new HashSet<Integer>(nums.length);
        for (int i:nums) {
            map.add(i);
        }
        //排重
        Object[] dis = map.toArray();
        Arrays.sort(dis);//需要做一次排序
        System.out.println(Arrays.toString(dis));
        int m,n = dis.length - k;
        if (n >= 0){
            m = (int) dis[n];
        }else{
            m = (int) dis[dis.length - 1];
        }
        return m;
//        if (k < 1 || nums == null) {
//            return 0;
//        }
//
//        return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    /**
     * 这种是， 快速排序， 有点没看懂
     * @param k
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

}
