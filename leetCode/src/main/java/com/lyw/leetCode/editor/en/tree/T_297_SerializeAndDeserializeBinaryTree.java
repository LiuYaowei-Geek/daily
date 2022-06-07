//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
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
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design Bin
//ary Tree 
// 👍 6697 👎 258


package com.lyw.leetCode.editor.en.tree;

import com.lyw.leetCode.model.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：T_297_Serialize and Deserialize Binary Tree
public class T_297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
//        Solution solution = new T_297_SerializeAndDeserializeBinaryTree().new Solution();
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
    public class Codec {

        /**
         * 构造完全二叉树字符串，然后还原树
         * 时间复杂度O(n)， 空间复杂度O(n)
         */
        //分隔符
        private static final String spliter = ",";
        //树空节点序列化
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> stack = new LinkedList<>(Arrays.asList(data.split(spliter)));
            return buildTree(stack);
        }

        private TreeNode buildTree(Deque<String> stack) {
            String val = stack.pop();
            if (val.equals(NN)) {
                return null;
            } else {
                //按照完全二叉树进行还原
                TreeNode cur = new TreeNode(Integer.valueOf(val));
                cur.left = buildTree(stack);
                cur.right = buildTree(stack);
                return cur;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}