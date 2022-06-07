package com.lyw.leetCode;

import java.util.*;

/**
 * 17
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<String, String> inputMap =new HashMap<>();
        inputMap.put("2", "abc");
        inputMap.put("3", "def");
        inputMap.put("4", "ghi");
        inputMap.put("5", "jkl");
        inputMap.put("6", "mno");
        inputMap.put("7", "pqrs");
        inputMap.put("8", "tuv");
        inputMap.put("9", "wxyz");

        //res添加个空字符串，避免下面循环时需要判空
        res.add("");
        for (char i : digits.toCharArray()) {
            res = add(res, inputMap.get(String.valueOf(i)));
        }
        return res;
    }

    public static List<String> add(List<String> res, String item) {
        List<String> tempRes = new ArrayList<>();
        for (char i : item.toCharArray()) {
            for (String s : res) {
                tempRes.add(s + i);
            }
        }
        return tempRes;
    }
}
