package com.andy.annotation;

import java.io.Serializable;

@EntityInfo(value = "品牌类")
public class Brand implements Serializable {

    private static final long serialVersionUID = -6735631956016677249L;

    @Meaning
    private String name;// 品牌名称
    @Size(min = 10, max = 100)
    private String alias;// 别名
    private String operator;// 操作人

    @Meaning(value = "Integr类型年龄")
    private Integer age;

    @Meaning(value = "long类型年龄")
    private Long longAge;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Meaning(value = "我擦泪")
    public String getFuck() {
        return "我真是服了气了";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getLongAge() {
        return longAge;
    }

    public void setLongAge(Long longAge) {
        this.longAge = longAge;
    }

}