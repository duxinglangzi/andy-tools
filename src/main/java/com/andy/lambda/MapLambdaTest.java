package com.andy.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2018/9/13 </p>
 */
public class MapLambdaTest {

    public static void main(String[] args) {


        List<LambdaUser> list = Arrays.asList(new LambdaUser(1, "a"),
                new LambdaUser(2, "b"), new LambdaUser(3, "c"), new LambdaUser(4, "d"));

        // 将list集合按指定的字段转化为 map集合
        Map<Integer, LambdaUser> map = list.stream().collect(Collectors.toMap(LambdaUser::getAge, user -> user));
        map.forEach((age, user) -> {
            System.out.println(age);
            System.out.println(user.getName());
            System.out.println("---------");
        });

        // 将list集合转化为map集合，过滤某些字段
        Map<Integer, LambdaUser> filterMap = list.stream().filter(user -> user.getAge() != 3).collect(Collectors.toMap(LambdaUser::getAge, user -> user));
        filterMap.forEach((age, user) -> {
            System.out.println(age);
            System.out.println(user.getName());
            System.out.println("++++++++++++++++");
        });


        List<LambdaUser> userList = Arrays.asList(new LambdaUser(1, "小红"),
                new LambdaUser(2, "小花"), new LambdaUser(2, "小黄"), new LambdaUser(4, "小蓝"));
        Map<Integer, List<LambdaUser>> filterGroupByMap = userList.stream().filter(user -> user.getAge() != 3).collect(Collectors.groupingBy(LambdaUser::getAge));
        filterGroupByMap.forEach((age, listUser) -> {
            System.out.println(age);
            listUser.forEach(lambdaUser -> System.out.println(lambdaUser.getName()));
            System.out.println("==================");
        });


        // 有一种情况非常常见，那就是如果集合转map结构时候，可能会出现重复的key ，那么这时候会发生一个错误 java.lang.IllegalStateException: Duplicate key
        Map<Integer, LambdaUser> lambdaUserMap = userList.stream().collect(Collectors.toMap(LambdaUser::getAge, e -> e));// 错误的写法。

        // 因此这地方需要做一个排重操作，只留一个
        Map<Integer, LambdaUser> lambdaUserMap2 = userList.stream().collect(Collectors.toMap(LambdaUser::getAge, e -> e, (a, b) -> a));// 正确的写法。
        // 这里写 a 表示，只留第一个。 如果写 b 表示只留 第二个


    }

}
