package com.andy.concurrent.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    public static AtomicInteger i = new AtomicInteger(0);// 所有的线程操作同一个对象
    public volatile static int A = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("i累计前" + TestAtomic.i + ",A累计前：" + TestAtomic.A);
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    TestAtomic.A++;
                    TestAtomic.i.getAndIncrement();
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    TestAtomic.A--;
                    TestAtomic.i.decrementAndGet();
                }
            }
        });
        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.print("i累计后" + TestAtomic.i + ",A累计后：" + TestAtomic.A);

    }
}
