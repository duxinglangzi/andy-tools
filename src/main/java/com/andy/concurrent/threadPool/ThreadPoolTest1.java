package com.andy.concurrent.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2021/6/17 </p>
 */
public class ThreadPoolTest1 {



    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executors = new ThreadPoolExecutor(
                3,
                3,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        // ThreadPoolExecutor.CallerRunsPolicy 策略
        // 表示如果等待队列饱和，则当前任务由 主线程执行，而不放入线程池 执行。


        System.out.println("开始啦~~~~~~~~~~~");

        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            try{
                executors.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 当前是: "+NO);
                    calate(NO);
                });
            }catch (Exception e){
                e.printStackTrace();
                System.err.println(e.getMessage());
            }

        }


//        TimeUnit.SECONDS.sleep(30);



    }

    public static void calate(Integer NO){
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
            System.out.println(Thread.currentThread().getName() +" -- "+ NO +" 睡眠完毕. ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
