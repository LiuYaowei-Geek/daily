package com.lyw.leetCode.hot100;
//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics Stack Tree Depth-First Search Binary Tree 
// 👍 7165 👎 318


import com.lyw.leetCode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
  * questionId：94
  * question：Binary Tree Inorder Traversal
  * date：2022-03-15 22:42:56
*/
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        System.out.println(solution.inorderTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)))));
        System.out.println(solution.inorderTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(2, new TreeNode(2), null))));
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
     * 树：
     *    1
     *  2   3
     * 4 5 6 7
     * 中序遍历：
     * 4, 2, 5, 1, 6, 3, 7
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        //结果
        List<Integer> res = new ArrayList<>();
        //用栈控制节点数据输出顺序，每个节点都会存进来
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            //出栈
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
