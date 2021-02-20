package com.andy.concurrent;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>ClassName: Fork-Join框架的简单实用 </p>
 * <p>Description: 在此准备一个  </p>
 * <p>@author wuqiong  2017/12/25 16:14 </p>
 */
public class ForkJoinTest extends TestCase {

    /**
     * 我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。它提供在任务中执行fork()和join的操作机制，通常我们不直接继承ForkjoinTask类，只需要直接继承其子类。
     * 1、RecursiveAction，用于没有返回结果的任务
     * 2、RecursiveTask，用于有返回值的任务
     * <p>
     * 在此我们继承 RecursiveTask 来简单实现一个  大数据量连续的数据 相加计算的操作
     * 1、核心思想就是，将一个任务切分成两个或者多个子任务进行单独计算，最后进行合并
     */

    public void test_fork_join() {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        NumberSum numberSum = new NumberSum(0L, 10000L);
//        forkJoinPool.execute(numberSum);//如果不需要返回值 直接使用即可
        try {
            System.out.println("开始前:" + System.currentTimeMillis());
            Future<Long> longFuture = forkJoinPool.submit(numberSum);
            System.out.println("总数sum值为 ： " + longFuture.get());
            System.out.println("结束后:" + System.currentTimeMillis());
            Assert.assertEquals(new Long(50005000L), longFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //可能是计算量不够大，forkjoin并不能比直接计算快...
//        AtomicLong atomicLong = new AtomicLong(0L);
//        System.out.println("计算完成前时间:"+System.currentTimeMillis());
//        for (Long i=0L;i<=10000L;i++){
//            atomicLong.addAndGet(i);
//        }
//        System.out.println("计算完成后: " +atomicLong.get());
//        System.out.println("计算完成后时间:"+System.currentTimeMillis());
    }

    /**
     * 有返回值的 任务
     */
    public static class NumberSum extends RecursiveTask<Long> {
        //1、适用于某个时间段的 数据量、交易量 等等
        //2、适用于计算

        private static final Long threshold = 100L;//可以直接求和的临界值。 当两数值相差不足此值时，直接求和
        private Long min;//计算的起始最小值
        private Long max;//计算的起始最大值

        NumberSum(Long min, Long max) {
            this.max = max;
            this.min = min;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Long compute() {
            Long sum = 0L;
            if ((max - min) <= threshold) {
                for (long i = min; i <= max; i++) {
                    sum = sum + i;
                }
            } else {
                //如果大于 threshold 值时，进行切分计算
                long mid = (max + min) >>> 1; //最小值和最大值相加除以2

                NumberSum ns1 = new NumberSum(min, mid);
                ns1.fork();//执行子任务
                NumberSum ns2 = new NumberSum(mid + 1, max);
                ns2.fork();
                sum = ns1.join() + ns2.join();
            }
            return sum;
        }
    }


    /**
     * 测试 fork-join 无返回值任务
     */
    public void test_RecursiveAction_task() {
        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();

            Job job = new Job(1L, 1000L);
            System.out.println("开始前:" + System.currentTimeMillis());
            Future future = forkJoinPool.submit(job);
            future.get();
            System.out.println("结束后:" + System.currentTimeMillis());
            /**
             * 开始前:1514271925106
             * 结束后:1514271926617
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    /**
     * 无返回值的 任务
     */
    public static class Job extends RecursiveAction {

        private static final Long threshold = 10L;//可以直接求和的临界值。 当两数值相差不足此值时，直接求和
        private Long min;//计算的起始最小值
        private Long max;//计算的起始最大值

        Job(Long min, Long max) {
            this.max = max;
            this.min = min;
        }

        /**
         * The main computation performed by this task.
         */
        @Override
        protected void compute() {

            //计算工作等等
            //1、适用于各种定时任务，负责执行即可，无需在意执行结果
            //2、适用于数据批量整理等等，整完即可。

            if ((max - min) <= threshold) {
                for (long i = min; i <= max; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                long mid = (max + min) >>> 1; //最小值和最大值相加除以2
                Job j1 = new Job(min, mid);
                j1.fork();//执行子任务
                Job j2 = new Job(mid + 1, max);
                j2.fork();
                j1.join();
                j2.join();
            }
        }
    }


}
