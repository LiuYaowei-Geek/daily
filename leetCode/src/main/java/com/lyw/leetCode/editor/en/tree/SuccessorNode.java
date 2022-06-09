/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

/**
 * 获取二叉树的后继节点，中序遍历当前位子的后一个节点
 *
 * @author pangu
 * @version : SuccessorNode.java, v 0.1 2022年04月25日 下午11:31 pangu Exp $
 */
public class SuccessorNode {
    public static void main(String[] args) {

    }

    private static TreeNode getSuccessorNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.right != null) {
            return getLeftMost(root);
        } else {//无右子树
            TreeNode parent = root.parent;
            //当前节点是其父节点的右孩子
            while (parent != null && parent.left != root) {
                root = parent;
                parent = root.parent;
            }
            return parent;
        }
    }

    private static TreeNode getLeftMost(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}