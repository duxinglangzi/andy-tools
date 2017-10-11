package com.andy.threadTest;

import com.andy.utils.SimpleDateUtils;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 定时器、定时任务
 *
 */
public class ScheduledExecutorServiceTest {

    private final static ScheduledExecutorService scheduler;


    static {
        scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1--轮循任务测试: " + SimpleDateUtils.to_DATE_TIME_FORMAT(new Date()));
            }
        },1L,10L,TimeUnit.SECONDS);

    }



    public static void main(String[] args) {

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前毫秒数: "+System.currentTimeMillis());
            }
        },10, TimeUnit.MILLISECONDS);


//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(2L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("1--轮循任务测试: " + SimpleDateUtils.to_DATE_TIME_FORMAT(new Date()));
//            }
//        },1L,10L,TimeUnit.SECONDS);


        scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2--轮循任务测试: " + SimpleDateUtils.to_DATE_TIME_FORMAT(new Date()));
                scheduler.shutdown();
            }
        },1L,10L,TimeUnit.SECONDS);


        System.out.println(scheduler.isShutdown());


    }

}
