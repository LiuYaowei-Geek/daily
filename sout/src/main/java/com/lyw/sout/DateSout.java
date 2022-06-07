package com.lyw.sout;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;


public class DateSout {
    public static void main(String[] args) {
        /**
         * 给定某一天，返回加上多少天
         */
        System.out.println(DateUtil.offsetDay(new DateTime("20190517", DatePattern.PURE_DATE_PATTERN), 100));
    }
}
