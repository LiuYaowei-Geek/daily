package com.lyw.leetCode.editor.en.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    public static class MyCompartor implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs, new MyCompartor());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

}
