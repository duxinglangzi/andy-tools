package com.andy.concurrent.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>ClassName: 线程通讯的简单测试 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/12/22 11:30 </p>
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();//锁对象
    private final Condition condition = lock.newCondition();//工作对象条件


    public void work() {
        lock.lock();
        try {
            try {
                System.out.println("Begin Work 开始干活~ ");
                condition.await();
                System.out.println("Begin End 干完了 ~ ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public void continueWork() {
        lock.lock();
        try {
            condition.signalAll();//唤醒所有线程
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.work();
            }
        }).start();

        //等待3秒后唤醒，继续工作。
        TimeUnit.SECONDS.sleep(3);
        test.continueWork();
    }



}
