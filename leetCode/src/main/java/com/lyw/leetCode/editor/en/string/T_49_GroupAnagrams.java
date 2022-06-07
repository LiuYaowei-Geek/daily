//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
// Related Topics Hash Table String Sorting 
// 👍 9069 👎 312


package com.lyw.leetCode.editor.en.string;


import java.util.*;

//Java：T_49_Group Anagrams
public class T_49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new T_49_GroupAnagrams().new Solution();
        // TO TEST
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams1(strs));
        System.out.println(solution.groupAnagrams2(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //排序+hashMap
        //时间复杂度 O(nklogk) 空间复杂度 O(nk)。n=strs.length, k = Max(str)
        public List<List<String>> groupAnagrams1(String[] strs) {
            if (strs == null || strs.length < 1) {
                return new ArrayList<>();
            }

            //空间O(nk)
            Map<String, List<String>> map = new HashMap<>();
            //时间O(n)
            for (String str : strs) {
                char[] chs = str.toCharArray();
                //时间O(klogk)
                Arrays.sort(chs);
                //计算key，经过排序保证字母一样的单词，key也一样
                String key = new String(chs);
                //获取List<String>
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                //存入map中
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }


        //数组计数+hashMap，优化排序的耗时
        //时间复杂度 O(n(k+|Σ|)) 空间复杂度 O(n(k+|Σ|))。n=strs.length, k = Max(str)，|Σ|=26
        public List<List<String>> groupAnagrams2(String[] strs) {
            if (strs == null || strs.length < 1) {
                return new ArrayList<>();
            }

            //空间O(nk)
            Map<String, List<String>> map = new HashMap<>();
            //时间O(n)
            for (String str : strs) {
                //26个小写字母的数组，记录str中每个字母的位置
                char[] chs = new char[26];
                for (char c : str.toCharArray()) {
                    chs[c - 'a']++;
                }
                //计算key，经过排序保证字母一样的单词，key也一样
                String key = new String(chs);
                //获取List<String>
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                //存入map中
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}