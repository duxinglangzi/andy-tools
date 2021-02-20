package com.andy.concurrent.synchronizer;

import java.util.concurrent.*;

/**
 * <p>Description: 测试线程计数器   </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 *
 * @author wuqiong  2017年8月10日
 */
public class CountDownLatchTest {


    // 模拟了100米赛跑，10名选手已经准备就绪，裁判一声令下。当所有人都到达终点时，比赛结束。
    public static void main(String[] args) throws InterruptedException {

        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);


        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            exec.submit(new Thread(new LatchTest(end, NO, cyclicBarrier)));
        }
        System.out.println("比赛开始啦");
        // 等待end变为0，即所有选手到达终点
        end.await();
        // cyclicBarrier.reset();
        System.out.println("激烈的比赛结束了...");
        exec.shutdown();
    }


}

/**
 * <p>Description: 内部类 </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 *
 * @author wuqiong  2017年8月11日
 */
class LatchTest implements Runnable {
    private CountDownLatch end;
    private CyclicBarrier cyclicBarrier;
    private int number;

    public LatchTest(CountDownLatch end, int number, CyclicBarrier cyclicBarrier) {
        super();
        this.end = end;
        this.cyclicBarrier = cyclicBarrier;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            // 修改引入 循环栅栏， 此前操作存在逻辑漏洞，无法做到所有人同时起跑。
            cyclicBarrier.await();
//            System.out.println("第" + number + " 名选手启动:" + System.currentTimeMillis());
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("第" + number + " 名选手到达终点");
        } catch (InterruptedException | BrokenBarrierException e) {
        } finally {
            // 每个选手到达终点时，end就减一
            end.countDown();
        }
    }

}


