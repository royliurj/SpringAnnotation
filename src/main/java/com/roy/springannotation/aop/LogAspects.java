package com.roy.springannotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//告诉Spring当前类是一个切面类
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //1, 本类使用 @Before("pointCut()")
    //2, 外部类使用 使用全名 com.roy.springannotation.aop.LogAspects.pointCut()
    @Pointcut("execution(public int com.roy.springannotation.aop.MathCaclulator.*(..))")
    public void pointCut(){};

    //切入MathCalculator下的所有方法，参数不限
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() +"运行，参数列表：是" + Arrays.asList(args));
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "结束");
    }
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){

        System.out.println(joinPoint.getSignature().getName() + "正常返回，结果是：" + result);
    }
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        System.out.println(joinPoint.getSignature().getName() + "异常，异常是：" + exception);
    }
}
