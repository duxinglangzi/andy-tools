package com.andy.codeCollector;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2020/7/2 </p>
 */
public class sssssss {

    public static void main(String[] args) {


        int hashCode = Math.abs("e31340LLQX7kSCB2".hashCode());
        int subTableId = hashCode % 20;
        System.out.println(subTableId < 10 ? ("0" + subTableId) : ("" + subTableId));



        for (int i = 9, j = 0; j < 1; i--, j++) System.out.println(i);

    }


}
