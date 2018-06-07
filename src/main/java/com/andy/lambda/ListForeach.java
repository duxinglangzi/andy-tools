package com.andy.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterators;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2018/6/7 </p>
 */
public class ListForeach {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("E");
        stringList.add("F");
        stringList.add("G");

        /**
         *  简单的写法: 相当于
         * <pre>
         *     for (String str : stringList) {
         *         System.out.println(str);
         *      }
         * </pre>
         */
        stringList.forEach(str -> System.out.println(str));
        /**
         * 此种方式同上， 一样， 只不过多增加 一组大括号而已
         * 区别是，如果循环内还有其他操作，可在大括号内完成，
         * 而上面一种方式是只有一行代码可以简写大括号
         */
        stringList.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("--------分割线--------");
        System.out.println(stringList.stream().count());
        System.out.println(stringList.size());






    }
}
