package com.andy.concurrent.juc.lock;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>ClassName: 锁 的使用，基本用法和条件 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/12/28 15:06 </p>
 */
public class ReentrantLockTest extends TestCase{

    /**
     * ReentrantLock 重入锁
     * 概念: 当一个线程占有当前方法块或代码块时， 由其它因素导致当前线程需再次访问时，无需排队阻塞直接进入。但是state 状态会在原来基础上 增加 1。
     *       直到当前线程完全释放锁，state 才会变为0， 此时可以 通知下一个阻塞的线程进入处理其业务.
     *
     *
     *
     */
    public static final Lock reentrantLock = new ReentrantLock();



    //测试锁
    public void testIssue(){
        reentrantLock.lock();//必须使用在 try-catch 外面
        try {
            System.out.println("测试锁开始了 ："+System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(2);//假装睡眠两秒
            System.out.println("测试锁完毕了 ："+System.currentTimeMillis());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //必须在 finally 里面释放当前锁.否则当try内发生错误，当前锁将永远不会被释放
            reentrantLock.unlock();
        }
    }



}
