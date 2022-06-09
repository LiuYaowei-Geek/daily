package com.lyw.leetCode.hot100;
//Given an integer n, return the number of structurally unique BST's (binary sea
//rch trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree 
// 👍 6866 👎 273

/**
  * questionId：96
  * question：Unique Binary Search Trees
  * date：2022-03-16 17:57:08
*/
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @link:{https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)}
     *G(n): the number of unique BST for a sequence of length n.
     * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
     *
     *G(n) = F(1, n) + F(2, n) + ... + F(n, n).
     *G(0)=1, G(1)=1.
     *
     *Hope it will help you to understand :
     *
     *     n = 0;     null
     *
     *     count[0] = 1
     *
     *
     *     n = 1;      1
     *
     *     count[1] = 1
     *
     *
     *     n = 2;    1__       			 __2
     *     		      \					/
     *     		     count[1]	   	count[1]
     *
     *     count[2] = 1 + 1 = 2
     *
     *
     *
     *     n = 3;    1__				      __2__	                   __3
     *     		      \		            /       \			      /
     *     		  count[2]		  count[1]    count[1]		count[2]
     *
     *     count[3] = 2 + 1 + 2  = 5
     *
     *
     *
     *     n = 4;    1__  					__2__					   ___3___
     *     		      \				 /        \					  /		  \
     *     		  count[3]		 count[1]    count[2]		  count[2]   count[1]
     *
     *                  __4
     *                /
     *            count[3]
     *
     *     count[4] = 5 + 2 + 2 + 5 = 14
     *
     *
     * And  so on...
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
