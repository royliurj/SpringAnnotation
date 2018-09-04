package com.roy.springannotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

    public Boss(Car car){
        this.car = car;
    }

    public Car car;

    public Car getCar() {
        return car;
    }

//    @Autowired
    //标注在方法上，Spring容器创建当前对象的时候，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
