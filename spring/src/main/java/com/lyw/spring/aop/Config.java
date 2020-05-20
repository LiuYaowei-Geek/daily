package com.lyw.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {com.lyw.spring.aop.Buy.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
