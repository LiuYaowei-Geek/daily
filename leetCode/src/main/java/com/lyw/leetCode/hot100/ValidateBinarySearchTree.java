package com.lyw.leetCode.hot100;
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
// 👍 9138 👎 863

import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

/**
  * questionId：98
  * question：Validate Binary Search Tree
  * date：2022-03-17 14:17:38
*/
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
    /**
     * 二叉搜索树
     *    5
     *  2   8
     * 1 3 6 9
     *
     * 中序遍历结果
     * 1 2 3 5 6 8 9
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //二叉搜索树，中序遍历就是从小到大排序
            if (null != pre && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
