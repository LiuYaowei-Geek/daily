package com.lyw.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class BoyBuy implements Buy {

    @Override
    public String buy(String price) {
        System.out.println(String.format("boy buy: %s", price));
        return "游戏机";
    }
}
