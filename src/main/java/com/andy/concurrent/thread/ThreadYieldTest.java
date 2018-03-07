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

    /**
     * 线程的优先级  一共分为10个等级，
     * 初始化线程 默认等级为5 。
     * 最小优先级是 1
     * 最高优先级是 10
     * 调用 Thread.yield(); 表示 等待比其本身高优先级的线程先 通过后，本身才会进行
     * @param args
     */
    public static void main(String[] args) {
        ThreadYieldTest threadYieldTest = new ThreadYieldTest();
        Thread thread2 = new Thread(() -> threadYieldTest.test_yield());
        System.out.println(thread2.getPriority()+"第一个");
        thread2.setPriority(1);

        Thread thread =new Thread(() -> threadYieldTest.test_yield());
        thread.setPriority(10);
        System.out.println(thread.getPriority());


        thread.start();
        thread2.start();

    }

}
