package com.roy.springannotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    /**
     *
     * @param conditionContext 可以使用的上下文环境
     * @param annotatedTypeMetadata 当前注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //获取ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        //获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        //获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        boolean person = registry.containsBeanDefinition("person");
        System.out.println("容器中是否包含person：" + person);

        //获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if(property.startsWith("Windows")){
            return true;
        }
        return false;
    }
}
