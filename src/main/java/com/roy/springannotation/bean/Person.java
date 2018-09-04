package com.roy.springannotation.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    public Person() {
    }

    public Person(String name, Integer age) {
//        System.out.println("创建Person");
        this.name = name;
        this.age = age;
    }

    /**
     * 1，基本数值
     * 2，SpEL #{}
     * 3，${} 从配置文件（properties环境变量里的值）中获取值
     */
    @Value("张三")
    private String name;

    @Value("#{100-50}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
