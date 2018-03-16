package com.andy.designPattern.creational.singleton;

import org.junit.Assert;

/**
 * <p>ClassName:单例模式  </p>
 * <p>Description: 单例模式，即一个类只允许存在一个实例。 </p>
 * <p>@author wuqiong  2017/11/30 14:41 </p>
 */
public class SingletonPattern{

    /**
     * 懒汉式，线程不安全，在使用时初始化示例（懒加载）
     */
    static class Singleton1 {
        private static Singleton1 instance;

        private Singleton1() {
            new AssertionError("don't support reflect.");
        }

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 懒汉式，线程安全，在使用时初始化示例（懒加载）
     */
    static class Singleton2 {
        private static Singleton2 instance;

        private Singleton2() {
            new AssertionError("don't support reflect.");
        }

        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 懒汉式线程安全的优化写法，双重检验锁模式（double checked locking pattern）
     */
    static class Singleton3 {
        private volatile static Singleton3 instance;

        private Singleton3() {
            new AssertionError("don't support reflect.");
        }

        public static Singleton3 getInstance() {
            if (instance == null) { // Single Checked
                synchronized (Singleton3.class) {
                    if (instance == null) { // Double checked
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 饿汉式 static final field，在类被被类加载器加载时便创建实例
     */
    static class Singleton4 {

        private static final Singleton4 instance = new Singleton4();

        private Singleton4() {
            new AssertionError("don't support reflect.");
        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 使用静态内部类 static nested class ,这种方法是《Effective Java》上所推荐的
     */
    static class Singleton5 {
        //静态内部类， 不能忘记啊。
        private static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {
            new AssertionError("don't support reflect.");
        }

        public static final Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 使用枚举，这也是单例模式最简单的实现 ,这种方法也是《Effective Java》上所推荐的
     */
    public enum Singleton6 {
        INSTANCE;
    }

    public static void main(String[] args) {
        Assert.assertEquals(Singleton1.getInstance(), Singleton1.getInstance());
        Assert.assertEquals(Singleton1.getInstance(), Singleton1.getInstance());
        Assert.assertEquals(Singleton2.getInstance(), Singleton2.getInstance());
        Assert.assertEquals(Singleton3.getInstance(), Singleton3.getInstance());
        Assert.assertEquals(Singleton4.getInstance(), Singleton4.getInstance());
        Assert.assertEquals(Singleton5.getInstance(), Singleton5.getInstance());
        Assert.assertEquals(Singleton6.INSTANCE, Singleton6.INSTANCE);

        Assert.assertEquals(Singleton6.INSTANCE, Singleton6.INSTANCE);
    }

}
