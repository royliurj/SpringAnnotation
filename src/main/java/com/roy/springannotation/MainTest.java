package com.roy.springannotation;

import com.roy.springannotation.aop.MathCaclulator;
import com.roy.springannotation.bean.Boss;
import com.roy.springannotation.bean.Car;
import com.roy.springannotation.bean.Color;
import com.roy.springannotation.bean.Person;
import com.roy.springannotation.config.*;
import com.roy.springannotation.dao.BookDao;
import com.roy.springannotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

public class MainTest {

    static AnnotationConfigApplicationContext context = null;//new AnnotationConfigApplicationContext(AutowireConfig.class);

    @Autowired
    Person person;

    public static void main(String[] args) {
//        test1();
//        test2();
//        test03();
//        testImport();
//        testLifeCycle();
//        testProperties();
//        testAutowired();
//        testProfile();
        testAop();
        context.close();
    }

    private static void testAop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

        MathCaclulator mathCaclulator = context.getBean(MathCaclulator.class);
        mathCaclulator.div(20,0);

    }

    private static void testProfile(){
        //创建context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设置激活的环境
        context.getEnvironment().setActiveProfiles("test");
        //注册配置类
        context.register(ProfileConfig.class);
        //启动刷新容器
        context.refresh();

        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name: beanNamesForType) {
            System.out.println(name);
        }
    }


    private static void testAutowired(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowireConfig.class);
        System.out.println(context);
//        print();
//
//        BookService bookService = context.getBean(BookService.class);
//        System.out.println(bookService);

//        Boss bean = context.getBean(Boss.class);

//        System.out.println(bean.getCar());

//        Color color = context.getBean(Color.class);
//        System.out.println(color.getCar());

//        BookDao bookDao = context.getBean(BookDao.class);
//        System.out.println(bookDao);
    }

    public static void testProperties(){
        print();
        System.out.println(context.getBean(Person.class));

        //也可以通过环境获取
        System.out.println(context.getEnvironment().getProperty("person.nickName"));
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
