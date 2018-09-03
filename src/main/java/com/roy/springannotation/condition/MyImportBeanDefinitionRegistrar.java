package com.roy.springannotation.condition;

import com.roy.springannotation.bean.Red;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    //annotationMetadata : 当前类注解
    //beanDefinitionRegistry ： BeanDefinition注册类，调用registerBeanDefinition手动注册Bean
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.roy.springannotation.bean.Blue");
        if(blue){
            beanDefinitionRegistry.registerBeanDefinition("red",new RootBeanDefinition(Red.class));
        }
    }
}
