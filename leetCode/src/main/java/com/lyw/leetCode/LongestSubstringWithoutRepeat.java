package com.lyw.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    private static int solution(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(str.charAt(i), i);
            for (int j = i + 1; j < str.length(); j++) {
                if (map.containsKey(str.charAt(j))) {
                    count = (j - i) > count ? (j - i) : count;
                    break;
                } else {
                    map.put(str.charAt(j), j);
                }
                if (j == str.length() - 1) {
                    count = (j - i + 1) > count ? (j - i + 1) : count;
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aa";
        solution(str);
        System.out.println(solution(str));
    }
}
