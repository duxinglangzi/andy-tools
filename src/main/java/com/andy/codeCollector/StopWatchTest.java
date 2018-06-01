package com.andy.codeCollector;

import org.apache.commons.lang.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * <p>ClassName: java 计时器小工具 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/12 13:56 </p>
 */
public class StopWatchTest {

    public static final ThreadLocal<StopWatch> STOP_WATCH_THREAD_LOCAL = new ThreadLocal<>();


    public static void main(String[] args) {
        setTime();
        try {
            TimeUnit.MILLISECONDS.sleep(1503);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getTime();
    }

    public static void setTime(){
        StopWatch stopWatch = STOP_WATCH_THREAD_LOCAL.get();
        if(stopWatch==null){
            stopWatch = new StopWatch();
            STOP_WATCH_THREAD_LOCAL.set(stopWatch);
            stopWatch.start();
        }
    }

    public static void getTime(){
        StopWatch stopWatch = STOP_WATCH_THREAD_LOCAL.get();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }


}
