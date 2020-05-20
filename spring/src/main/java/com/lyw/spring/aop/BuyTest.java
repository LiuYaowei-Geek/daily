package com.lyw.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BuyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BoyBuy boyBuy = context.getBean("boyBuy", BoyBuy.class);
        GirlBuy girlBuy = context.getBean("girlBuy", GirlBuy.class);
//        boyBuy.buy();
        String price = "99";
        girlBuy.buy(price);
        System.out.println(price);
    }
}
