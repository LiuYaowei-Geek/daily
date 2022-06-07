//Given the roots of two binary trees p and q, write a function to check if they
// are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
//
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 5755 👎 135


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.TreeNode;

//Java：T_100_Same Tree
public class T_100_SameTree {
    public static void main(String[] args) {
        Solution solution = new T_100_SameTree().new Solution();
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

        public boolean isSameTree2(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }
            if (p.val == q.val) {
                return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
            }
            return false;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            return inorderTravel(p, new StringBuilder()).equals(inorderTravel(q, new StringBuilder()));
        }

        private String inorderTravel(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null");
            } else {
                sb.append(root.val);
                inorderTravel(root.left, sb);
                inorderTravel(root.right, sb);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}