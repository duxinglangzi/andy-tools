package com.andy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * <p>ClassName: ThreadLocal 简单使用 </p>
 * <p>@author wuqiong  2018/1/16 11:47 </p>
 */
public class ThreadLocalTest {

    /**
     * 原理: ThreadLocal 是采用键、值对象为值的存储结构，这个结构被附带在线程上，也就是说一个线程可以根据一个ThreadLocal查询绑定到这个线程上的一个值。
     * ThreadLocal键是一个弱引用，当线程被JVM的 gc 回收时，引用消失，随之值也会回收释放。几乎不会出现内存问题.
     * <p>
     * 原理补充： 只要线程处于活动状态并且ThreadLocal实例可以访问，每个线程就拥有对其线程局部变量副本的隐(弱)式引用。
     * 在一个线程消失之后，线程本地实例的所有副本都会被垃圾收集（注:除非存在对这些副本的其他引用）.
     * 因此如果副本被长时间占用，那么可能也会造成内存泄漏问题。
     * <p>
     * 1、ThreadLocal 可以用来保存和传递 变量、 经典用法:com.github.pagehelper.PageHelper.startPage()
     * 2、可以用来变量副本，如: SimpleDateUtils 保存指定格式的SimpleDateFormat 变量。此时可支持多线程访问。
     * <p>
     * <p>
     * 注意事项: 如果在多线程、线程池内使用 ThreadLocal 时，必须在当前线程结束时清除当前线程内容。否则会因线程池复用此线程，导致数据
     * 污染问题，从而产生其他bug 信息
     */

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();//开始时间
        //休眠 1000 毫秒
        TimeUnit.MILLISECONDS.sleep(1000L);
        Long longValue = ThreadLocalTest.end();//结束时间
        //用当前时间，减去 放入ThreadLocal内的时间
        System.out.println("耗时为:" + (System.currentTimeMillis() - longValue));

    }

    //初始化
    public static final ThreadLocal<Long> INTEGER_THREAD_LOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static final void begin() {
        INTEGER_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final Long end() {
        return INTEGER_THREAD_LOCAL.get();
    }

}
