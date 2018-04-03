package com.andy.concurrent;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 *  测试多线程处理任务
 *
 */
public class Threads {

    public static void main(String[] args) {

        CountDownLatch countDownLatch =new CountDownLatch(3);
        ConcurrentMap concurrentMap =new ConcurrentHashMap(12,0.75F);
        long start = System.currentTimeMillis();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟睡眠 2秒
                    TimeUnit.MILLISECONDS.sleep(2000L);
                    concurrentMap.put(Thread.currentThread().getName(),"one");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟睡眠 1秒
                    TimeUnit.MILLISECONDS.sleep(1000L);
                    concurrentMap.put(Thread.currentThread().getName(),"two");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟睡眠 2秒
                    TimeUnit.MILLISECONDS.sleep(3000L);
                    concurrentMap.put(Thread.currentThread().getName(),"three");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println("进入等待......");
            //执行等待，完毕后 进行 输出
            countDownLatch.await();
            System.out.println("执行时间: " + (System.currentTimeMillis() - start));
            System.out.println("maps 长度 ： "+concurrentMap.size());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
