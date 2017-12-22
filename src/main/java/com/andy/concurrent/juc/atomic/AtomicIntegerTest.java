package com.andy.concurrent.juc.atomic;

import org.junit.Assert;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>ClassName: AtomicIntegerTest 测试类 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/30 13:51 </p>
 */
public class AtomicIntegerTest {
    public static AtomicInteger sharedValue = new AtomicInteger();

    //每次将sharedValue的值增加10
    public static void increment() {
        for (int i = 0; i < 10; i++) {
            sharedValue.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int maxThreads = 10000;
        for (int i = 0; i < maxThreads; i++) {
            Thread thread = new Thread(() -> increment());//jdk 8 表达式
            thread.start();
        }

        Thread.sleep(3000);//等待所有子线程执行完成
        Assert.assertEquals(sharedValue.get(), 10000 * 10);
        new AssertionError("this is fuck ");
    }


}
