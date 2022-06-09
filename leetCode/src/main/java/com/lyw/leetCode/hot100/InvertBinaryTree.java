package com.lyw.leetCode.hot100;
//Given the root of a binary tree, invert the tree, and return its root. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,3,1]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 7912 👎 106


import com.lyw.leetCode.model.TreeNode;

/**
  * questionId：226
  * question：Invert Binary Tree
  * date：2022-03-27 14:57:49
*/
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(root.val, root.right, root.left);
        invert(root);
        return res;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
        invert(node.left);
        invert(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
