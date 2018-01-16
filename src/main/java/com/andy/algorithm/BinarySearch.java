package com.andy.algorithm;

/**
 * <p>ClassName: 算法 -  折半查找法 - 二分查找法 </p>
 * <p>@author wuqiong  2018/1/15 18:30 </p>
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrays={1,2,3,4,5,6,7,8,9,10,11,22};
        System.out.println("当前值是否存在于集合中:"+search(arrays,5));

    }

    /**
     * 方法描述: 折半 - 二分查找法   针对于有序的集合
     * 折半查找的前提条件是在一个有序的序列中。首先确定待查记录所在的区间，然后逐步的缩小范围区间直到找到或者找不到该记录为止。与数学中的二分法一样。
     * @return boolean
     * @author wuqiong  2018/1/15 18:31
     */
    public static boolean search(int[] arrays,int keyword) {
        int low = 0;
        int height = arrays.length - 1;
        int mid;
        while (low <= height) {
            mid = (low + height) >>> 1; //除2
            if (arrays[mid] > keyword) {
                height = mid - 1;
            } else if (arrays[mid] < keyword) {
                low = mid + 1;
            } else if (arrays[mid] == keyword) {
                return true;
            }
        }
        return false;


    }

}
