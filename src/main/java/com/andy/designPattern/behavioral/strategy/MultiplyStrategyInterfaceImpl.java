package com.andy.designPattern.behavioral.strategy;

/**
 * 乘法运算
 *
 * @author sunny
 * @create 2017/11/24 14:29
 **/
public class MultiplyStrategyInterfaceImpl implements StrategyInterface {
    /**
     * a与b的运算，
     *
     * @param a 入参
     * @param b 入参
     * @return 结果
     */
    @Override
    public int Calculation(int a, int b) {
        return a * b;
    }
}
