package com.andy.threadTest;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: 描述该类实现了什么功能 </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 *
 * @author wuqiong  2017年8月11日
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        //如果将参数改为20，但是下面只加入了10个选手，这永远等待下去
        //Waits until all parties have invoked await on this barrier.
        CyclicBarrier barrier = new CyclicBarrier(10);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(new Thread(new Runner(barrier, "1号选手")));
        executor.submit(new Thread(new Runner(barrier, "2号选手")));
        executor.submit(new Thread(new Runner(barrier, "3号选手")));
        executor.submit(new Thread(new Runner(barrier, "4号选手")));
        executor.submit(new Thread(new Runner(barrier, "5号选手")));
        executor.submit(new Thread(new Runner(barrier, "6号选手")));
        executor.submit(new Thread(new Runner(barrier, "7号选手")));
        executor.submit(new Thread(new Runner(barrier, "8号选手")));
        executor.submit(new Thread(new Runner(barrier, "9号选手")));
        executor.submit(new Thread(new Runner(barrier, "10号选手")));


        //模拟赛跑程序      加入10个人跑步，
        executor.shutdown();
    }
}

class Runner implements Runnable {
    // 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
    private CyclicBarrier barrier;

    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        super();
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(8));
            System.out.println(name + " 到达终点");
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            barrier.await();
            System.out.println("heihei ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
