package com.andy.designPattern.behavioral.strategy;

/**
 * 策略者接口
 *
 * @author sunny
 * @create 2017/11/24 14:24
 **/
public interface StrategyInterface {


    /**
     * a与b的运算，a+b a-b a/b a*b
     *
     * @param a 入参
     * @param b 入参
     * @return 结果
     */
    int Calculation(int a, int b);

}
