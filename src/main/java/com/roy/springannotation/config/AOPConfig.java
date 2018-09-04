package com.roy.springannotation.config;

import com.roy.springannotation.aop.LogAspects;
import com.roy.springannotation.aop.MathCaclulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.management.ManagementFactory;

/**
 * 只在程序运行期间动态的将某段代码切入到指定的方法指定位置运行的编程方式
 * 原理： 动态代理
 * 1，导入Aop模块
 * 2，定义逻辑类MathCalculator，在业务逻辑运行时，将日志进行打印（方法运行之前，之后，异常等）
 * 3，定义一个日志切面类LogAspects，类里的方法需要动态感知div运行到哪里
 *      通知方法：
 *          前置通知(@Before)logStart
 *          后置通知(@After)logEnd
 *          返回通知(@AfterReturning)logReturn
 *          异常通知(@AfterThrowing)logException
 *          环绕通知(@Around)
 * 4，给切面类的方法标注何时何地运行
 * 5，将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6，必须告诉Spring那个类是切面类(@Aspect)
 * 7，给配置类中加入@EnableAspectJAutoProxy 启用基于注解的Aop模式
 */
@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {
    //将业务逻辑类加入到容器中
    @Bean
    public MathCaclulator mathCaclulator(){
        return new MathCaclulator();
    }
    //将切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
