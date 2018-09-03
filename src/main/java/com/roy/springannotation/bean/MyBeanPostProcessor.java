package com.roy.springannotation.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    //初始化之前处理
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("before Initialization ..." + s + " => " + o);
        return o;
    }
    //初始化之后处理
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("after Initialization ..." + s + " => " + o);
        return o;
    }
}
