package com.roy.springannotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {
    public Dog(){
        System.out.println("Dog constructor");
    }
    @PostConstruct
    public void postConstructor(){
        System.out.println("Dog postConstructor");
    }
    @PreDestroy
    public void preDestory(){
        System.out.println("dog pre destroy");
    }
}
