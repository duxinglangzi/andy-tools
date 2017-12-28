package com.andy.concurrent.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>ClassName: Condition  条件对象的应用 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/12/28 16:20 </p>
 */
public class ConditionImplTest {

    private static  final Lock lock=new ReentrantLock();
    private static final Condition put=lock.newCondition();
    private static final Condition read=lock.newCondition();
    public static final List<Object> list = new ArrayList<>();
    private static final int max = 100;

    public void producer(Integer num){
        lock.lock();
        try {
            if(num >= (max-list.size())){
                System.out.println("工厂空间不够，暂时无法生产. 剩余空间为:"+(max-list.size()));
                put.await();
            }else{
                for(int i =0;i<num;i++){
                    list.add(new Object());
                }
            }
            System.out.println("通知消费产品,目前余量:"+list.size());
            read.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(Integer num){
        lock.lock();
        try {
            if(num > list.size()){
                System.out.println("工厂产品不足, 剩余数量为 : "+list.size());
                read.await();
            }else{
                for(int i= 0;i<num;i++){
                    list.remove(list.size()-1);
                }
            }
            System.out.println("通知继续生产,目前余量"+list.size());
            put.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        ConditionImplTest conditionImplTest =new ConditionImplTest();

        Producer p1=new Producer(conditionImplTest,18);
        Producer p2=new Producer(conditionImplTest,30);
        Producer p3=new Producer(conditionImplTest,40);


        Consumer c1= new Consumer(conditionImplTest,18);
        Consumer c2= new Consumer(conditionImplTest,30);
        Consumer c3= new Consumer(conditionImplTest,40);


        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();


        try {
            p1.join();
            p2.join();
            p3.join();
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("工厂到底屯了多少货 : "+ConditionImplTest.list.size());


        //该生产者 消费者 有些瑕疵。

    }



}

class Producer extends Thread{
    private ConditionImplTest conditionImplTest;
    private Integer num;
    Producer(ConditionImplTest conditionImplTest,int num){
        this.conditionImplTest=conditionImplTest;
        this.num=num;
    }
    @Override
    public void run(){
        conditionImplTest.producer(num);
    }

}

class Consumer extends Thread{
    private ConditionImplTest conditionImplTest;
    private Integer num;
    public Consumer(ConditionImplTest conditionImplTest,int num){
        this.conditionImplTest=conditionImplTest;
        this.num=num;
    }
    @Override
    public void run(){
        conditionImplTest.consumer(num);
    }
}