package com.andy.concurrent.juc.atomic;

import java.io.Serializable;

/**
 * <p>ClassName: 用户信息 </p>
 * <p>@author wuqiong  2018/1/25 15:57 </p>
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8894178960793173309L;

    public String name;
    volatile int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }





}
