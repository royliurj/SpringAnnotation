package com.roy.springannotation.config;

import com.roy.springannotation.bean.Person;
import com.roy.springannotation.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 配置类等同于以前的Xml文件
 * excludeFilters 指定排除规则
 * includeFilters 指定包含规则，必须设置useDefaultFilters= false才能生效
 * FilterType.ANNOTATION : 按照注解过滤
 * FilterType.ASSIGNABLE_TYPE : 按照指定类型
 * FilterType.CUSTOM : 自定义过滤，必须继承接口TypeFilter
 */
@Configuration
@ComponentScan(value = "com.roy.springannotation", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
}, includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
public class MyConfig {

    //为容器注册一个组件bean;类型为返回值的类型，id默认是用方法名为id
    @Bean(name = "person")
    public Person person01(){
        return new Person("roy",22);
    }
}
