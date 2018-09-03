package com.roy.springannotation.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个SPring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象
    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单例
    public boolean isSingleton() {
        return true;
    }
}
