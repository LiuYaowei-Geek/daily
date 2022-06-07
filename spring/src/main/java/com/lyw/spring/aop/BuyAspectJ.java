package com.lyw.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BuyAspectJ {

    @Pointcut("execution(* com.lyw.spring.aop.Buy.buy(..))")
    public void point() {}

    @Pointcut("execution(* com.lyw.spring.aop.Buy.buy(String)) && args(price) && bean(girlBuy)")
    public void girlPoint(String price) {}

    @Around("girlPoint(price)")
    public String girlAround(ProceedingJoinPoint pj, String price) {
        try {
            pj.proceed();
            if (Integer.valueOf(price) > 68) {
                System.out.println("女孩买衣服超过了68元，赠送一双袜子");
                price = "100";
                return "衣服和袜子";
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "衣服";
    }


    @Before("point()")
    public void before() {
        System.out.println("aop before");
    }

    @After("execution(* com.lyw.spring.aop.Buy.buy(..))")
    public void after() {
        System.out.println("aop after");
    }

    @AfterReturning("execution(* com.lyw.spring.aop.Buy.buy(..))")
    public void afterReturning() {
        System.out.println("aop AfterReturning ...");
    }

    @Around("execution(* com.lyw.spring.aop.Buy.buy(..))")
    public void around(ProceedingJoinPoint pj) {
        try {
            System.out.println("aop Around aaa ...");
            pj.proceed();
            System.out.println("aop Around bbb ...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
