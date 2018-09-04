package com.roy.springannotation.config;

import com.roy.springannotation.bean.Car;
import com.roy.springannotation.bean.Color;
import com.roy.springannotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring利用依赖注入（DI），完成IOC容器中各个组件的依赖关系赋值
 * 1) @Autowired 自动注入，
 *      a，优先按照类型找组件
 *      b，如果存在多个，在按照组件名查找。
 *      c，@Qualifer可以指定需要装配组件的名称 @Qualifer("bookDao")
 *      d，自动装配，默认一定要装配，没有就报错 @Autowired(required=false)
 *      e，@Primary，让Spring自动装配的时候默认使用首选的Bean， 不能与@Qualifer共用，如果指定了@Qualifer，则优先使用指定的Bean
 * 2) @Resource（JSR250规范）和@Inject（JSR330规范）【Java规范】
 *      a，@Resource(name="bookDao2") 指定名称，默认按照属性名装配，没有required和Primary的支持
 *      b，@Inject ，需要导入javax.inject包，和Autowired一样，没有required的支持
 */
@Configuration
@ComponentScan(value = {"com.roy.springannotation.service",
        "com.roy.springannotation.controller",
        "com.roy.springannotation.dao",
        "com.roy.springannotation.bean"})
public class AutowireConfig {

    @Primary //如果存在多个bean，首选这个bean，不能与@Qualifer共用
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao =  new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    //这里的car也是从容器中获取的，可以标注@Autowired也可以不用标注
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
