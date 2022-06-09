package com.lyw.leetCode.hot100;
//You are given a string s. We want to partition the string into as many parts a
//s possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Greedy 
// 👍 7534 👎 287

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * questionId：763
  * question：Partition Labels
  * date：2022-04-14 20:13:58
*/
public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        //记录字符最大的索引位子
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int last = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            //last记录最后重复的字符位子
            last = Math.max(last, map.get(s.charAt(i)));
            //i位子的字符最后出现的位子
            if (last == i) {
                res.add(last - start + 1);
                //移动start位子
                start = last + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
