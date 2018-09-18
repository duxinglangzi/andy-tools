package com.andy.lambda;

import java.io.Serializable;

/**
 * <p>Description:使用方法引用 (ClassName::Method) </p>
 * <p>
 *     举例: LambdaUser::getAge
 *     说明: 不需要 .  不需要调用方法的括号
 * </p>
 * <p>@Author wuqiong  2018/6/19 </p>
 */
public class LambdaUser implements Serializable {
    private static final long serialVersionUID = -6695055648419479965L;

    private int age;
    private String name;

    LambdaUser(Integer age,String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
