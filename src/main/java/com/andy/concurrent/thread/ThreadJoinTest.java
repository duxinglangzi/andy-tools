package com.andy.concurrent.thread;

/**
 * <p>ClassName: 测试 thread.join 方法的作用 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/2 16:08 </p>
 */
public class ThreadJoinTest{

    public static void main(String[] args) {

//        try {
            Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--t1 测试");
                }
            });
            t1.start();
//            t1.join();

            Thread t2= new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--t2 测试");
                }
            });
            t2.start();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("全都执行完毕");


        /**
         * 启用join 时，输出如下
         * Thread-0--t1 测试
         * Thread-1--t2 测试
         * 全都执行完毕
         */


        /**
         * 注释 join 时，输出如下
         *  全都执行完毕
         *  Thread-0--t1 测试
         *  Thread-1--t2 测试
         */

    }




}
