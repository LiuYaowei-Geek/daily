//Given the root of a binary search tree, and an integer k, return the kth small
//est value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete op
//erations) and you need to find the kth smallest frequently, how would you optimi
//ze? 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 7179 👎 133


package com.lyw.leetCode.editor.en.tree;

import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

//Java：T_230_Kth Smallest Element in a BST
public class T_230_KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new T_230_KthSmallestElementInABst().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 中序遍历
         * 时间复杂度O(n)， 空间复杂度O(n)
         * @param root
         * @param k
         * @return
         */
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            int count = 1;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (count == k) {
                    return root.val;
                }
                count++;
                root = root.right;
            }
            throw new IllegalArgumentException("error input");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}