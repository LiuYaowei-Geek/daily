//Given the roots of two binary trees root and subRoot, return true if there is 
//a subtree of root with the same structure and node values of subRoot and false o
//therwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree and
// all of this node's descendants. The tree tree could also be considered as a sub
//tree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash Funct
//ion 
// 👍 5361 👎 288


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

//Java：T_572_Subtree of Another Tree
public class T_572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new T_572_SubtreeOfAnotherTree().new Solution();
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
         * 1.不能直接使用完全二叉树做判断，二叉树BFS和DFS都不能解决局部的问题，因为局部子树不满足BFS和DFS。可以通过在叶子节点追加null节点，然后使用kmp算法，即前面完全二叉树转字符串算法
         * 2. DFS，时间复杂度O(mn)，空间复杂度O(max(m,n))
         * 3. KMP, 时间复杂度O(m + n)，空间复杂度O(m + n)
         *
         * @param root
         * @param subRoot
         * @return
         */
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }
            if (isSame(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSame(TreeNode first, TreeNode seconde) {
            if (first == null && seconde == null) {
                return true;
            }
            if (first == null || seconde == null) {
                return false;
            }
            if (first.val != seconde.val) {
                return false;
            }
            return isSame(first.left, seconde.left) && isSame(first.right, seconde.right);
        }

        /**
         * 1.不能直接使用完全二叉树做判断，二叉树BFS和DFS都不能解决局部的问题，因为局部子树不满足BFS和DFS。可以通过在叶子节点追加null节点，然后使用kmp算法，即前面完全二叉树转字符串算法
         * 2. KMP, 时间复杂度O(m + n)，空间复杂度O(m + n)
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubtreeWithKMP(TreeNode s, TreeNode t) {
            String sPreOrder = generatePreOrderString(s);
            String tPreOrder = generatePreOrderString(t);

            return sPreOrder.contains(tPreOrder);
        }

        public String generatePreOrderString(TreeNode s) {
            StringBuilder sb = new StringBuilder();
            Stack<TreeNode> stacktree = new Stack<>();
            stacktree.push(s);
            while (!stacktree.isEmpty()) {
                TreeNode cur = stacktree.pop();
                if (cur == null) {
                    // Appending # inorder to handle same values but not subtree cases
                    sb.append(",#");
                } else
                    sb.append(",").append(cur.val);
                if (cur != null) {
                    stacktree.push(cur.right);
                    stacktree.push(cur.left);
                }
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}