package com.lyw.leetCode.hot100;
//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child po
//inter points to the next node in the list and the left child pointer is always n
//ull. 
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related 
//Topics Linked List Stack Tree Depth-First Search Binary Tree 
// 👍 6719 👎 458


import com.lyw.leetCode.model.TreeNode;

/**
  * questionId：114
  * question：Flatten Binary Tree to Linked List
  * date：2022-03-19 22:03:02
*/
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(root);
        System.out.println("");
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
     * 题解链接
     * @link:{https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/1207642/JS-Python-Java-C%2B%2B-or-Simple-O(1)-Space-and-Recursive-Solutions-w-Explanation}
     */
    TreeNode head = null;
    public void flatten(TreeNode root) {
        if (root != null) {
            revPreOrder(root);
        }
    }

    private void revPreOrder (TreeNode node) {
        if (node.right != null) {
            revPreOrder(node.right);
        }
        if (node.left != null) {
            revPreOrder(node.left);
        }
        node.left = null;
        node.right = head;
        head = node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
