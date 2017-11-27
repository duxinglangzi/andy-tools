package com.andy.strategy;


/**
 * 除法运算
 *
 * @author sunny
 * @create 2017/11/24 14:31
 **/
public class DivideStrategyInterfaceImpl implements StrategyInterface {
    /**
     * a与b的运算，a/b
     *
     * @param a 入参
     * @param b 入参
     * @return 结果
     */
    @Override
    public int Calculation(int a, int b) {
//        if(b==0){
//            throw new Exception("除数为0");
//        }
        return a/b;
    }
}
