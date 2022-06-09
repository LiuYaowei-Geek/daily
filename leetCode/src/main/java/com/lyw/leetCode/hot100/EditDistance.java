package com.lyw.leetCode.hot100;
//Given two strings word1 and word2, return the minimum number of operations req
//uired to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 8147 👎 92

/**
  * questionId：72
  * question：Edit Distance
  * date：2022-04-15 12:28:28
*/
public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int replace = cost[i][j];
                    int delete = cost[i][j + 1];
                    int insert = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        return cost[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
