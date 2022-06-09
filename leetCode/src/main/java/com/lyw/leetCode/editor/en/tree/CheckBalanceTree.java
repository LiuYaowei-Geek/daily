/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

/**
 * 判断是否为平衡二叉树
 * @author pangu
 * @version : CheckBalanceTree.java, v 0.1 2022年04月25日 下午9:38 pangu Exp $
 */
public class CheckBalanceTree {
    public static void main(String[] args) {

    }

    private static boolean isBalance(TreeNode root) {
        return process(root).isBalanced;
    }

    private static class BalanceTreeType {
        public boolean isBalanced;
        private int height;

        public BalanceTreeType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static BalanceTreeType process(TreeNode root) {
        if (root == null) {
            return new BalanceTreeType(true, 0);
        }
        BalanceTreeType left = process(root.left);
        BalanceTreeType right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        return new BalanceTreeType(isBalanced, height);
    }
}