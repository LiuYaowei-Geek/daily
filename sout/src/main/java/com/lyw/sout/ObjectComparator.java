package com.lyw.sout;


import com.lyw.sout.modle.InvestorInfo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuyaowei488
 * @date created in 2020-4-16 14:01
 */
public class ObjectComparator {
    public static void main(String[] args) {
        InvestorInfo i1 = new InvestorInfo();
        i1.setQuota("1");

        InvestorInfo i2 = new InvestorInfo();
        i2.setQuota("2");

        InvestorInfo i3 = new InvestorInfo();
        i3.setQuota("3");

        InvestorInfo i4 = new InvestorInfo();
        i4.setQuota("4");

        List<InvestorInfo> investorInfos = Arrays.asList(i4, i2, i3, i1);
        //内部类方法排序
//        Collections.sort(investorInfos, new Comparator<InvestorInfo>() {
//            @Override
//            public int compare(InvestorInfo o1, InvestorInfo o2) {
//                return new BigDecimal(o1.getQuota()).compareTo(new BigDecimal(o2.getQuota()));
//            }
//        });
        //倒序
        investorInfos.sort((o1, o2) -> new BigDecimal(o2.getQuota()).compareTo(new BigDecimal(o1.getQuota())));
        //倒序
        investorInfos.sort(Comparator.comparing(o -> new BigDecimal(o.getQuota())));
        System.out.println(investorInfos);
//        System.out.println(new BigDecimal("1").compareTo(new BigDecimal("2")));
    }
}
