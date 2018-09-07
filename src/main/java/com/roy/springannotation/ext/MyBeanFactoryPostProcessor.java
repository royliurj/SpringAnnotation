package com.roy.springannotation.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory");
        int beanDefinitionCount = configurableListableBeanFactory.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount+"个");
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.asList(beanDefinitionNames));
    }
}
