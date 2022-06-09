package com.lyw.leetCode.hot100;
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
// 👍 6530 👎 123


import com.lyw.leetCode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
  * questionId：104
  * question：Maximum Depth of Binary Tree
  * date：2022-03-19 16:38:05
*/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                TreeNode temp = queue.poll();
                if (null != temp.left) {
                    queue.add(temp.left);
                }
                if (null != temp.right) {
                    queue.add(temp.right);
                }
            }
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
