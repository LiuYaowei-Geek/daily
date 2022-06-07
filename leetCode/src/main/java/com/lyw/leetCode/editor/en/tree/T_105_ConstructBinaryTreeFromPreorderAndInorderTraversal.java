//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 8596 👎 235


package com.lyw.leetCode.editor.en.tree;

import com.lyw.leetCode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

//Java：T_105_Construct Binary Tree from Preorder and Inorder Traversal
public class T_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new T_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
         * 时间复杂度O(n)，空间复杂度O(n)
         * 思路：
         * 1. 先序遍历，第一个数就是根节点，第二个数是根节点的左节点，跳过所有左节点后是右节点
         * 2. 找到根节点在中序遍历中的位置，中序遍历里，根节点左侧都是左节点，就能拿到左节点列表数量，右边都是右节点列表
         * 3. 递归构建左子树和右子树
         *
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            //参数非法时直接返回空节点
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }
            //现需便利中preStart是根节点
            TreeNode root = new TreeNode(preorder[preStart]);
            // Index of current root in inorder
            int inIndex = 0;
            //找到当前根节点在中序遍历的位置
            //中序遍历中inStart到index-1是当前根节点左节点列表，index+1到inEnd是当前根节点右节点列表
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inIndex = i;
                }
            }
            //preStart + 1是当前根节点左节点的位置
            //inStart到index-1是当前根节点左节点列表
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
            //preStart + inIndex - inStart + 1是当前根节点右节点的位置
            //preStart是当前根节点位置，跳过所有左节点就能找到右节点位置，中序遍历中，根节点左边都是左节点列表，所以inIndex - inStart + 1是左节点数量
            //index+1到inEnd是当前根节点右节点列表
            root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
            return root;
        }

        public TreeNode buildTreeWithMap(int[] preorder, int[] inorder) {
            //利用map减少每次for循环寻找根节点在中序遍历中位置的耗时
            Map<Integer, Integer> inOrderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            //子节点为null
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            //根节点
            TreeNode root = new TreeNode(preorder[preStart]);
            //中序遍历的索引
            int inRoot = inMap.get(root.val);
            //当前根节点左节点数量
            int numsLeft = inRoot - inStart;
            //构造左子树
            root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
            //构造右子树
            root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}