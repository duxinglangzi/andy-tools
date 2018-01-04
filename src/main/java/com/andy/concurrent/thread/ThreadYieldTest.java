package com.andy.concurrent.thread;

/**
 * <p>ClassName: Thread - yield 测试 线程优先级 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/4 17:16 </p>
 */
public class ThreadYieldTest {



    public void test_yield(){

        for (int i = 0 ;i<3;i++){
            System.out.println(Thread.currentThread().getName()+" 第 "+i+" 号" + Thread.currentThread().getPriority());
            Thread.yield();
        }


    }

    public static void main(String[] args) {
        ThreadYieldTest threadYieldTest = new ThreadYieldTest();
        Thread thread2 = new Thread(() -> threadYieldTest.test_yield());
        System.out.println(thread2.getPriority()+"第一个");
        thread2.setPriority(1);
        thread2.start();
        Thread thread =new Thread(() -> threadYieldTest.test_yield());
        thread.setPriority(10);
        System.out.println(thread.getPriority());
        thread.start();


    }

}
