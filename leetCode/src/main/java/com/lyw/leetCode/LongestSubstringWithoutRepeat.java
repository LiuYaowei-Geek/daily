package com.lyw.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    /**
     * self
     *
     * @param str
     * @return
     */
    private static int solution1(String str) {
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

    /**
     * Brute Force
     * Time complexity : O(n^3)
     * Space complexity : O(min(n, m))O(min(n,m))
     *
     * @param s
     * @return
     */
    private static int solution2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;

    }

    /**
     * Sliding Window
     * Time complexity : O(2n)=O(n)
     * Space complexity : O(min(m, n))
     *
     * @param s
     * @return
     */
    private static int solution3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * Sliding Window Optimized
     * Time complexity : O(n)
     * Space complexity (HashMap) : O(min(m, n))
     * Space complexity (Table): O(m)
     *
     * @param s
     * @return
     */
    private static int solution4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aa";
        solution1(str);
        System.out.println(solution1(str));
    }
}
