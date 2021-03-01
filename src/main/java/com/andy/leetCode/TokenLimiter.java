package com.andy.leetCode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: 超级简单的 令牌桶算法 </p>
 * <p>@Author wuqiong  2021/2/23 </p>
 */
public class TokenLimiter {


    // 总令牌个数
    private int limit;
    private ArrayBlockingQueue<Integer> arrayBlockingQueue;

    // 每个令牌持续时间值
    private int period;
    private TimeUnit timeUnit;


    public TokenLimiter(int limit, ArrayBlockingQueue<Integer> arrayBlockingQueue, int period, TimeUnit timeUnit) {
        this.limit = limit;
        this.arrayBlockingQueue = arrayBlockingQueue;
        this.period = period;
        this.timeUnit = timeUnit;
        init();
        start();
    }

    // 获取
    public boolean tryAcquire() {
        return arrayBlockingQueue.poll() == null ? false : true;
    }

    // 初始化
    private void init() {
        for (int i = 0; i < limit; i++) {
            arrayBlockingQueue.add(1);
        }
    }

    private void addToken() {
        arrayBlockingQueue.offer(1);
    }

    private void start() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            addToken();
        }, 1, period, timeUnit);
    }


    public static void main(String[] args) {

        TokenLimiter tokenLimiter = new TokenLimiter(5, new ArrayBlockingQueue<Integer>(5), 1, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            if (!tokenLimiter.tryAcquire()) {
                try {
                    System.out.println("申请失败了: " + i);
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("申请成功: " + i);
            }
        }
        System.exit(1);

        // 输出结果如下

//        申请成功: 0  // 申请成功了  0、1、2、3、4
//        申请成功: 1
//        申请成功: 2
//        申请成功: 3
//        申请成功: 4
//        申请失败了: 5  // 申请失败了，此时队列没有空桶 ，TokenLimiter 内部的线程池在跑着呢。
//        申请成功: 6   // 6、7 申请成功了，说明线程池追加了一些 空桶
//        申请成功: 7
//        申请失败了: 8 // 8 失败了，说明线程池上次仅追加了两个空桶， 因此8再去申请时，失败了。
//        申请成功: 9   // 恰好9 的时候， 线程池又追加了一些空桶，所以 就导致 9 申请成功了


    }


}
