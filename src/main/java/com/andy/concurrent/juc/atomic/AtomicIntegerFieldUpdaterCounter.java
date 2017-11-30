package com.andy.concurrent.juc.atomic;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterCounter {
    // 步骤1 构造方法
    private static final AtomicIntegerFieldUpdater<Details> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Details.class, "numberTimesInvoked");

    // 步骤2 对AtomicIntegerFieldUpdater修饰的变量进行操作
    public int addOne(Details details) {
        // performs a "x = x + 1" style atomic operation
        // return atomicIntegerFieldUpdater.addAndGet( details, 1 );
        return this.atomicIntegerFieldUpdater.getAndIncrement(details);
    }

    public int subOne(Details details) {
        return atomicIntegerFieldUpdater.decrementAndGet(details);
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicIntegerFieldUpdaterCounter atomicIntegerFieldUpdaterCounter = new AtomicIntegerFieldUpdaterCounter();

        final Details d = new Details();
        System.out.print("对象d的变量numberTimesInvoked累计前:" + d.getNumberTimesInvoked());
        System.out.println(",A累计前：" + TestAtomic.A);
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    atomicIntegerFieldUpdaterCounter.addOne(d);
                    TestAtomic.A++;
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    TestAtomic.A++;
                    atomicIntegerFieldUpdaterCounter.subOne(d);
                }
            }
        });
        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.print("对象d的变量numberTimesInvoked累计后:" + d.getNumberTimesInvoked());
        System.out.println(",A累计后：" + TestAtomic.A);
    }
}
