package com.andy.ConsumerAndProducer;

public class Test {

    public static void main(String[] args) {
        // 仓库对象
        Storage storage = new Storage();


        // 生产者对象
        Producer p1 = new Producer(storage, 10);
        Producer p2 = new Producer(storage, 10);
        Producer p3 = new Producer(storage, 10);
        Producer p4 = new Producer(storage, 10);
        Producer p5 = new Producer(storage, 10);
        Producer p6 = new Producer(storage, 10);
        Producer p7 = new Producer(storage, 80);

        // 消费者对象 // 设置消费者产品消费数量
        Consumer c1 = new Consumer(storage, 50);
        Consumer c2 = new Consumer(storage, 20);
        Consumer c3 = new Consumer(storage, 30);


        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
