//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 9942 👎 897


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

//Java：T_98_Validate Binary Search Tree
public class T_98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new T_98_ValidateBinarySearchTree().new Solution();
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
         * 二叉搜索树，中序遍历就是从小到大排序
         * 时间复杂度O(n)，空间复杂度O(n)
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return false;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode preNode = null;
            //中序遍历，节点不为空或者栈不为空
            while (root != null || !stack.isEmpty()) {
                //节点不为空时，深度搜索左节点
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                //二叉搜索树，中序遍历就是从小到大排序
                if (preNode != null && preNode.val >= root.val) {
                    return false;
                }
                //记录前一个节点
                preNode = root;
                //左节点和根节点处理完后，处理右节点
                root = root.right;
            }
            return true;
        }

        /**
         * 时间复杂度O(n)， 空间复杂度O(n)
         * @param root
         * @return
         */
        public boolean isValidBSTWithRecursion(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long minVal, long maxVal) {
            if (root == null) {
                return true;
            }
            if (root.val >= maxVal || root.val <= minVal) {
                return false;
            }
            return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}