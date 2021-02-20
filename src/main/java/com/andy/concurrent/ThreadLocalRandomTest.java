package com.andy.concurrent;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>Description: 测试多线程下进行随机数获取 </p>
 * <p>@Author wuqiong  2018/5/3 </p>
 */
public class ThreadLocalRandomTest {
    /**
     * 1、Random是线程安全的，但是多线程下可能性能比较低
     * 2、在多线程情况下，不要使用 Random类，更不要 多个方法公用一个Random对象
     * 3、
     */
    public static void main(String[] args) {

        Random random = new Random();
        System.out.println(random.nextInt(234));


        ThreadLocalRandom tlr = ThreadLocalRandom.current();

        System.out.println(tlr.nextInt(0, 100000));


    }

}
