package com.andy.designPattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试策略模式
 *
 * @author sunny
 * @create 2017/11/24 14:39
 **/
public class TestStrategy {
    private static Map<String, StrategyInterface> map = new HashMap<>();

    static {
        map.put("plus", new PlusStrategyInterfaceImpl());
        map.put("minus", new MinusStrategyInterfaceImpl());
        map.put("multiply", new MultiplyStrategyInterfaceImpl());
        map.put("divide", new DivideStrategyInterfaceImpl());
    }

    public static void main(String[] args) {
        if (args != null) {
            StrategyInterface strategy = map.get(args[0]);
            System.out.println(strategy.Calculation(10, 2));
        }
    }
}
