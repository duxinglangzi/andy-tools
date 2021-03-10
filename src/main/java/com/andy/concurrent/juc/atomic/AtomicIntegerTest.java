package com.andy.concurrent.juc.atomic;

import org.junit.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;
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

        testThreadHungry();

//        int maxThreads = 10000;
//        for (int i = 0; i < maxThreads; i++) {
////            Thread thread = new Thread(() -> increment());
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    increment();
//                }
//            });
//            thread.start();
//        }

        Thread.sleep(3000);//等待所有子线程执行完成
        Assert.assertEquals(sharedValue.get(), 10000 * 10);
        new AssertionError("this is kkkkkk ");
    }


    // 测试线程饿死现象
    public static void testThreadHungry(){

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 25; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int count;
                    if((count = atomicInteger.incrementAndGet()) > 10 ){
                        System.out.println("超过10个了, 当前是:" + count);
                        return;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        atomicInteger.decrementAndGet();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        // 可以得出结论，在使用 AtomicInteger 时，需要注意 incrementAndGet 方法的执行逻辑，
        // 此方法逻辑是 先获取再 + 1 然后返回，这就造成了多1个的情况。
        // 因此在使用过程中需要特别注意一下。  防止

        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("现在线程还有:" + atomicInteger.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出内容如下:
//        超过10个了, 当前是:11
//        超过10个了, 当前是:12
//        超过10个了, 当前是:13
//        超过10个了, 当前是:14
//        超过10个了, 当前是:15
//        超过10个了, 当前是:16
//        超过10个了, 当前是:17
//        超过10个了, 当前是:18
//        超过10个了, 当前是:19
//        超过10个了, 当前是:20
//        超过10个了, 当前是:21
//        超过10个了, 当前是:22
//        超过10个了, 当前是:23
//        超过10个了, 当前是:24
//        现在线程还有:14


    }

}
