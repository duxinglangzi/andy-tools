package com.andy.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: 测试排序的lambda写法 </p>
 * <p>@Author wuqiong  2018/6/28 </p>
 */
public class SortList {

    //给入一个List
    private static List<String> list = Arrays.asList("my", "name", "is", "uber", "and", "uc");

    /** 对一个String的list进行排序 - 使用老方法  */
    public static void oldSort() {
        //排序
        Collections.sort(list, new Comparator<String>() {
            //使用新的排序规则 根据第二个字符进行逆序排
            @Override
            public int compare(String a, String b) {
                if (a.charAt(1) <= b.charAt(1)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    /** 新的排序方法 - 使用lambda表达式实现 */
    public static void newSort() {
        // lambda会自动推断出 a,b 的类型
        Collections.sort(list, (a, b) -> a.charAt(1) < b.charAt(1) ? 1 : -1);
    }

    public static void main(String[] args) {
//      oldSort();
        newSort();

        list.forEach(s -> System.out.println(s));


    }


}
