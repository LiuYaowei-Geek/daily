//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path f
//rom the root node down to the farthest leaf node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 6979 👎 124


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Java：T_104_Maximum Depth of Binary Tree
public class T_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new T_104_MaximumDepthOfBinaryTree().new Solution();
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
         * bfs广度优先
         * 时间复杂度O(n)，空间复杂度O(n)
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            int maxDepth = 0;
            if (root == null) {
                return maxDepth;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int tempSize = queue.size();
                for (int i = 0; i < tempSize; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                maxDepth++;
            }
            return maxDepth;
        }


        /**
         * dfs深度优先遍历
         * 时间复杂度O(n)
         * 空间复杂度O(depth)
         * @param root
         * @return
         */
        public int maxDepthWithRecursion(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepthWithRecursion(root.left), maxDepthWithRecursion(root.right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}