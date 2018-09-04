package com.roy.springannotation.config;

import com.roy.springannotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//加载外部配置文件
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class PropertiesValueConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
