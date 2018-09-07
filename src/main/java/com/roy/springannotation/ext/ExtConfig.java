package com.roy.springannotation.ext;

import com.roy.springannotation.bean.Blue;
import com.roy.springannotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理
 * BeanPostProcessor, bean后置处理器，bean穿件对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor, beanFactory后置处理器
 *      在BeanFacotry后调用，所有的bean定义已经保存加载到bean factory中，但是bean的实例还没有创建
 */
@ComponentScan("com.roy.springannotation.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Car car(){
        return new Car();
    }
}
