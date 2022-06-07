//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
// given nodes in the BST. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [2,1], p = 2, q = 1
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 105]. 
// -109 <= Node.val <= 109 
// All Node.val are unique. 
// p != q 
// p and q will exist in the BST. 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 5828 👎 190


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.TreeNode;

//Java：T_235_Lowest Common Ancestor of a Binary Search Tree
public class T_235_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new T_235_LowestCommonAncestorOfABinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        /**
         * 时间复杂度O(n)， 空间复杂度O(1)
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                //pq都在左侧
                if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                    //pq都在右侧
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.left;
                } else {
                    //pq一个在左一个在右
                    break;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}