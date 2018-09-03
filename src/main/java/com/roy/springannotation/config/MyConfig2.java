package com.roy.springannotation.config;

import com.roy.springannotation.bean.Person;
import com.roy.springannotation.condition.LinuxCondition;
import com.roy.springannotation.condition.WindowsCondition;
import org.springframework.context.annotation.*;


@Configuration
public class MyConfig2 {

    /**
     * 默认bean是单实例的，可以通过@Scope配置
     * prototype : 多实例的，使用的时候会创建
     * singleton ： 单实例的（默认值）, IOC容器启动就会创建
     * request: 同一个请求创建一个示例
     * session：同一个session创建一个实例
     */
    @Scope("prototype")
    @Bean("person")
    public Person person(){
        return new Person("aaa",33);
    }

    @Lazy
    @Bean("person2")
    public Person person2(){
        return new Person("bbb",34);
    }

    /**
     * @Conditional： 按照一定的条件判断，满足条件给容器中注册bean
     * 如果系统是windows就注入bill，
     * 如果是linux就注册linus
     */
    @Bean("bill")
    @Conditional({
            WindowsCondition.class
    })
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({
            LinuxCondition.class
    })
    @Bean("linus")
    public Person person02(){
        return new Person("Linus",58);
    }
}
