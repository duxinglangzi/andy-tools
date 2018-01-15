package com.andy.algorithm;

import java.util.Arrays;

/**
 * <p>ClassName: 冒泡排序 小demo </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/15 15:02 </p>
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("开始排序-----");
        int[] arrays=new int[]{1,5,4,7,2,3,45,345,3456,456,456};
        sort(arrays);
        System.out.println("排序完毕-----");
    }

    public static void sort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {    //最多做n-1趟排序
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] < arrays[j + 1]) {    //把小的值换到后面
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            System.out.println(Arrays.toString(arrays));
        }
    }


}
