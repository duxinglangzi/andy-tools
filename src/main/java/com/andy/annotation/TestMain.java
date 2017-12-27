package com.andy.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 *Title: 测试方法
 *@author wuqiong   2014-11-27
 */
public class TestMain {


    public static void trackBook(Class<?> cl){
        Brand b=new Brand();
        b.setName("丰田汽车");
        //获取属性注释
        Field[] fd=b.getClass().getDeclaredFields();
        for(int i=0;i<fd.length;i++){
            Meaning m = fd[i].getAnnotation(Meaning.class);
            fd[i].setAccessible(true);//修改访问权限
            if(m!=null){
                try {
                    System.out.println(fd[i].getName()+":"+(fd[i].get(b)==null));
                } catch (IllegalArgumentException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
                System.out.println("字段名:"+fd[i].getName());
                System.out.println("字段名:"+fd[i].toGenericString());
//				System.out.println("我擦泪:"+fd[i].getAnnotations());
                Annotation[] ann=fd[i].getAnnotations();
                System.out.println("---------："+ann.toString());
                System.out.println("字段注释："+m.value());
            }
        }


        //获取方法注释
        for (Method method : cl.getDeclaredMethods()){
            Meaning m1 = method.getAnnotation(Meaning.class);
            if (m1 != null) {
                System.out.println("方法的注解值是："+m1.value());
            }
        }


        //获取类的注释
        Annotation annotation=cl.getAnnotation(EntityInfo.class);
        EntityInfo e=(EntityInfo)annotation;
        System.out.println("类的注释值:"+e.value());
        System.out.println("类型值:"+e.annotationType());



    }


    public static void main(String[] args) {

        trackBook(Brand.class);

    }

}