package com.lyw.leetCode.hot100;
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
// 👍 8508 👎 294

import java.util.*;

/**
  * questionId：49
  * question：Group Anagrams
  * date：2022-03-09 20:35:06
*/
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams2(new String[] {"eat","tea","tan","ate","nat","bat"}));

        System.out.println('b' - 'a');
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(String.valueOf(ca), new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

        public List<List<String>> groupAnagrams2(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                //初始为0的数组
                char[] ca = new char[26];
                for (char c :str.toCharArray()) {
                    //str中存在的字面在ca数组中都加1进行标识存在，所以循环完，ca数组能够表示str中存在哪些字母
                    ca[c - 'a']++;
                }
                String key = String.valueOf(ca);
                if (!map.containsKey(key)) {
                    map.put(String.valueOf(ca), new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
