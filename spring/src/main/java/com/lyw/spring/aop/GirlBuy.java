package com.lyw.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class GirlBuy implements Buy {

    @Override
    public String buy(String price) {
        System.out.println(String.format("girl buy: %s", price));
        return "衣服";
    }
}
