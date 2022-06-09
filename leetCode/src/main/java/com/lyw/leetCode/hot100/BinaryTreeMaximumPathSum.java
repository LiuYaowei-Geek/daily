package com.lyw.leetCode.hot100;
//A path in a binary tree is a sequence of nodes where each pair of adjacent nod
//es in the sequence has an edge connecting them. A node can only appear in the se
//quence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any non-empty
// path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 
// 👍 9145 👎 529

import com.lyw.leetCode.model.TreeNode;

/**
  * questionId：124
  * question：Binary Tree Maximum Path Sum
  * date：2022-04-16 15:12:11
*/
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //初始化maxValue，因为节点值可能为负，所以初始化为Integer.MIN_VALUE
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //值为负数的话就取0
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        //计算maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        //选择left right中大的一个，决策left和right下一层的是选左边的还是右边的
        return Math.max(left, right) + node.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
