/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree.traversal;


import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

/**
 * @author pangu
 * @version : PreorderTraversal.java, v 0.1 2022年04月24日 下午8:09 pangu Exp $
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        System.out.println(preorderTraversalRecursion(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

        System.out.println(preorderTraversalUnRecur(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

    }

    /**
     * 递归
     * @param root
     * @param sb
     * @return
     */
    private static String preorderTraversalRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        sb.append(root.val).append(" ");
        preorderTraversalRecursion(root.left, sb);
        preorderTraversalRecursion(root.right, sb);
        return sb.toString();
    }

    /**
     * 1. 头节点入栈
     * 2. 从栈中弹出一个节点，并处理（打印）
     * 3. 当前节点右节点入栈，当前节点左节点入栈。如果存在的话
     * 4. 循环2，3，4
     *
     * @param root
     * @param sb
     * @return
     */
    private static String preorderTraversalUnRecur(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            sb.append(root.val).append(" ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return sb.toString();
    }

}