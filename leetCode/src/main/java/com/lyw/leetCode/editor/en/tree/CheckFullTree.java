/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

/**
 * @author pangu
 * @version : CheckFullTree.java, v 0.1 2022年04月25日 下午10:09 pangu Exp $
 */
public class CheckFullTree {
    public static void main(String[] args) {

    }

    private static boolean isFull(TreeNode root) {
        ReturnType res = process(root);
        //(2^n - 1) == 节点树
        return res.nodes == (1 << res.height) + 1;
    }

    private static class ReturnType {
        public int height;
        public int nodes;

        public ReturnType(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    private static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;

        return new ReturnType(height, nodes);

    }

}