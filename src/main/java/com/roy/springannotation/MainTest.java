package com.roy.springannotation;

import com.roy.springannotation.bean.Person;
import com.roy.springannotation.config.LifeCycleConfig;
import com.roy.springannotation.config.MyConfig;
import com.roy.springannotation.config.MyConfig2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class MainTest {

    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

    @Autowired
    Person person;

    public static void main(String[] args) {
//        test1();
//        test2();
//        test03();
//        testImport();
        testLifeCycle();
    }

    public static void testLifeCycle(){
//        print();

        context.close();
    }

    public static void testImport(){
        print();

        Object colorFactoryBean = context.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());

        Object colorFactoryBean2 = context.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean2.getClass());

    }

    private static void print(){
        String[] names = context.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
    }

    public static void test03(){
        //获取环境变量的值
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String[] names = context.getBeanNamesForType(Person.class);
        for (String name: names) {
            System.out.println(name);
        }
    }

    public static void test1(){

//        System.out.println(person);

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Person p = (Person) context.getBean("person");
//        System.out.println(p);

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        Person p = context.getBean(Person.class);
//        System.out.println(p);
//
//        String[] names = context.getBeanNamesForType(Person.class);
//        for (String name: names) {
//            System.out.println(name);
//        }

        String[] names = context.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
    }

    public static void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);

        String[] names = context.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }

        System.out.println("容器创建完成");
        Object o = context.getBean("person2");
        Object o2 = context.getBean("person2");


        System.out.println(o == o2);
    }
}
