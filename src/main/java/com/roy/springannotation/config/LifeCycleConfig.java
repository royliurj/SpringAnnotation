package com.roy.springannotation.config;

import com.roy.springannotation.bean.Car;
import com.roy.springannotation.bean.Dog;
import org.springframework.context.annotation.*;

/**
 * Bean的生命周期 创建-初始化-销毁
 *
 * 1）指定初始化销毁方法（例如数据源的初始化和释放资源）
 *      init-method和destroy-method
 * 2） InitializingBean和DisposableBean
 * 3) 使用JSR250规范的两个注解@PostConstruct(创建并且属性赋值完成，执行初始化) 和@PreDestory(Bean将要被移除之前)
 * 4) BeanPostProcessor 后置处理器
 */
@Configuration
@ComponentScan("com.roy.springannotation.bean")
@Import(Dog.class)
public class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
