package com.andy.codeCollector;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>ClassName: 用来测试引用传递 和 值传递的概念 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2017/11/20 15:03 </p>
 */
public class TestArgs {

    public static void main(String[] args) {

        Integer tagrt=10,source=20;

        System.out.println("tagrt值 :"+tagrt + "  ---   source值 : "+source);
        replace(tagrt,source);
        System.out.println("tagrt值 :"+tagrt + "  ---   source值 : "+source);
    }

    /**
     * 方法描述: 请让 a 和 b 的值互换
     * @author wuqiong  2017/11/20 15:07
     */
    public static void replace(Integer a,Integer b){

        try {
            int c = a; //自动装箱拆箱知识点
            Field field = Integer.class.getDeclaredField("value");//获取私有属性 和 公有属性知识点
            field.setAccessible(true); //设置属性访问权限知识点
            field.set(a,b);
            field.set(b,new Integer(c));//重置内存地址知识点
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
