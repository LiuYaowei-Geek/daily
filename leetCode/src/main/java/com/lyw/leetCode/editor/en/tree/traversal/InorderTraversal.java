/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree.traversal;


import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

/**
 * @author pangu
 * @version : InorderTraversal.java, v 0.1 2022年04月24日 下午8:33 pangu Exp $
 */
public class InorderTraversal {
    public static void main(String[] args) {
        System.out.println(inorderTraversalRecursion(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

        System.out.println(inorderTraversalUnRecursion(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

    }

    private static String inorderTraversalRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        inorderTraversalRecursion(root.left, sb);
        sb.append(root.val).append(" ");
        inorderTraversalRecursion(root.right, sb);
        return sb.toString();
    }

    /**
     * 1. 整棵树，左边界先入栈
     * 2. 栈弹出cur, 并处理(打印)
     * 3. cur右节点不为空时，以cur为根节点的整棵树，左边界进栈
     * 4. 循环2 3
     * @param root
     * @param sb
     * @return
     */
    private static String inorderTraversalUnRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                sb.append(root.val).append(" ");
                root = root.right;
            }
        }
        return sb.toString();
    }
}