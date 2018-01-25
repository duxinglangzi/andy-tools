package com.andy.concurrent.juc.atomic;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterCounter {
    // 步骤1 构造方法
    private static final AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    // 步骤2 对AtomicIntegerFieldUpdater修饰的变量进行操作
    public int addOne(User user) {
        // performs a "x = x + 1" style atomic operation
        // return atomicIntegerFieldUpdater.addAndGet( user, 1 );
        return this.atomicIntegerFieldUpdater.getAndIncrement(user);
    }

    public int subOne(User user) {
        return atomicIntegerFieldUpdater.decrementAndGet(user);
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicIntegerFieldUpdaterCounter atomicIntegerFieldUpdaterCounter = new AtomicIntegerFieldUpdaterCounter();

        final User user = new User();
        System.out.print("对象d的变量 age 累计前:" + user.getAge());
        System.out.println(",A累计前：" + TestAtomic.A);
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    atomicIntegerFieldUpdaterCounter.addOne(user);
                    TestAtomic.A++;
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100000; j++) {
                    TestAtomic.A--;
                    atomicIntegerFieldUpdaterCounter.subOne(user);
                }
            }
        });
        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.print("对象d的变量 age 累计后:" + user.getAge());
        System.out.println(",A累计后：" + TestAtomic.A);
    }
}
