/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree.traversal;


import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

/**
 * @author pangu
 * @version : PostorderTraversal.java, v 0.1 2022年04月24日 下午8:55 pangu Exp $
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        System.out.println(postorderTraversalRecursion(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

        System.out.println(postorderTraversalUnRecursion(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

    }

    private static String postorderTraversalRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        postorderTraversalRecursion(root.left, sb);
        postorderTraversalRecursion(root.right, sb);
        sb.append(root.val).append(" ");
        return sb.toString();
    }

    /**
     * 1. 头结点进栈1
     * 2. 栈1弹出cur, cur进栈2
     * 3. cur左节点进栈1，右节点进栈1
     * 4. 循环2 3
     * 5. 输出栈2的数据
     * @param root
     * @param sb
     * @return
     */
    private static String postorderTraversalUnRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.empty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        while (!stack2.empty()) {
            sb.append(stack2.pop().val).append(" ");
        }
        return sb.toString();
    }
}