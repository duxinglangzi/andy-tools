package com.andy.designPattern.creational.factory;

/**
 * <p>ClassName: 简单工厂 </p>
 * <p>Description: 简单工厂模式，简单来说就是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（该模式并不属于GOF 23） </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/30 14:39 </p>
 */
public class SimpleFactoryPattern {

    //汽车抽象
    static abstract class Car {
        abstract void run();
    }
    //奔驰汽车
    static class Benz extends Car {
        @Override
        void run() {
            System.out.println("奔驰车在跑");
        }
    }
    //宝马汽车
    static class BMW extends Car {
        @Override
        void run() {
            System.out.println("宝马车在跑");
        }
    }
    //汽车工厂，根据汽车名称创建汽车
    static class CarFactory {
        Car getCar(String name) {
            if (name.equals("Benz")) {
                return new Benz();
            } else if (name.equals("BMW")) {
                return new BMW();
            } else {
                throw new IllegalArgumentException("No support this car");
            }
        }
    }

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car car = factory.getCar("BMW");
        //Car car = factory.getCar("Benz");
        car.run();
    }

}
