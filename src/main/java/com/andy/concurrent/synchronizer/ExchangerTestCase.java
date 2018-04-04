package com.andy.concurrent.synchronizer;

import java.util.concurrent.Exchanger;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/3/7 13:36 </p>
 */
public class ExchangerTestCase {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str=exchanger.exchange("沃日勒狗了");
                    System.out.println("第一个线程打印 :" + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fyck=exchanger.exchange("真是服了气");
                    System.out.println("第二个线程打印 :" + fyck);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fyck=exchanger.exchange("下雪了  3");
                    System.out.println("第三个线程打印 :" + fyck);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fyck=exchanger.exchange("我的天啊  4");
                    System.out.println("第四个线程打印 :" + fyck);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


}
