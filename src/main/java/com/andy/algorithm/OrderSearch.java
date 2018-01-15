package com.andy.algorithm;

/**
 * <p>ClassName: 查找算法 - 顺序查找 </p>
 * <p>@author wuqiong </p>
 */
public class OrderSearch {

    public static void main(String[] args) {
        int[] arrays=new int[]{234,34,45,1,45,345,45,457};
        System.out.println("是否存在指定 457 数值:"+search(arrays,457));

    }

    public static boolean search(int[] array,int keyWord){
        for (int i = 0;i<array.length;i++){
            if(array[i]==keyWord)return true;
        }
        return false;
    }


}
