package com.andy.concurrent.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>ClassName: 条件对象 实用、简单概念 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/12/22 11:30 </p>
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();//锁对象


    /**
     * 条件对象: 在一个锁内，可以有多个条件对象， 用来在同一个锁内 进行多种业务处理等等
     * 用法 ： 当调用 await() 方法时，当前线程会释放该条件对象关联的锁， 并放弃 monitor(监视器) .
     * 当调用 signal()、signalAll() 方法时, 当前线程会重新得带 当前条件对象关联的锁，并且会继续执行当前线程余下的代码
     * <p>
     * 举例:  当 Thread1 得到 object1 的监控(monitor)时, 调用 object1.await() 方法进行阻塞 并释放 object1 锁持有的 monitor
     * 此时 Thread2 获取到 object1 的监控(monitor)， 调用 object1.signal() 方法。 此时Thread1重新获取到monitor, object1阻塞失效，并继续向下执行代码
     */
    private final Condition condition = lock.newCondition();//工作条件对象


    public void work() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----- Begin Work 开始干活~ ");
//                condition.await(3,TimeUnit.SECONDS);

            condition.await();//释放当前锁，
            System.out.println(Thread.currentThread().getName() + "----- End 干完了 ~ ");
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        ConditionTest test1 = new ConditionTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.work();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        test1.continueWork();

        //等待3秒后唤醒，继续工作。
        TimeUnit.SECONDS.sleep(3);
        test.continueWork();
    }


}
