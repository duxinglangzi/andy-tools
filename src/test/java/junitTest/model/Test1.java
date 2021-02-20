package junitTest.model;

import junitTest.BaseEntity;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/3/26 10:22 </p>
 */
public class Test1 {

    /**
     * @param args
     * @return void
     * @Description: 测试方法注释
     * @Author wuqiong 2018/4/8 12:47
     */
    public static void main(String[] args) {
        returnStringArgs("asd", 2123, new BaseEntity());
    }


    /**
     * @param [str, inte, baseEntity]
     * @return java.lang.String
     * @description： 不可能的可能
     * @author wuqiong 2018-04-08 13:08
     */
    public static String returnStringArgs(String str, Integer inte, BaseEntity baseEntity) {
        System.out.println("fule you ");

        return "String args";
    }


}
