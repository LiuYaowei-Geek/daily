/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

import java.util.Stack;

/**
 * 判断是否是搜索二叉树，使用中序遍历，从小到大顺序
 * @author pangu
 * @version : CheckBST.java, v 0.1 2022年04月25日 下午8:53 pangu Exp $
 */
public class CheckBST {
    public static void main(String[] args) {

    }

    private static int preValue = Integer.MIN_VALUE;

    //1
    private static boolean checkBSTRecursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean lestCheckRes = checkBSTRecursion(root.left);
        if (!lestCheckRes) {
            return false;
        }
        if (root.val > preValue) {
            preValue = root.left.val;
        } else {
            return false;
        }
        return checkBSTRecursion(root.right);
    }

    //2
    private static boolean checkBSTUnRecursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= preValue) {
                    return false;
                } else {
                    preValue = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }

    //3
    private static boolean isBST(TreeNode root) {
        return process(root).isBst;
    }

    private static class ReturnType {
        public boolean isBst;
        public int min;
        public int max;

        public ReturnType(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    private static ReturnType process(TreeNode root) {
        if (root == null) {
            return null;
        }

        ReturnType left = process(root.left);
        ReturnType right = process(root.right);

        int min = root.val, max = root.val;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }

        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }

        boolean isBst = true;
        if (left != null && (!left.isBst || left.max >= root.val)) {
            isBst = false;
        }
        if (right != null && (!right.isBst || right.min <= root.val)) {
            isBst = false;
        }
        return new ReturnType(isBst, min, max);
    }


}