/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 找一颗树中两个子树最近的父节点
 * @author pangu
 * @version : LowestCommonAncestor.java, v 0.1 2022年04月25日 下午10:43 pangu Exp $
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    private static TreeNode getLowestCommonAncestorWithRecursion(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null || root == t1 || root == t2) {
            return root;
        }
        TreeNode left = getLowestCommonAncestorWithRecursion(root.left, t1, t2);
        TreeNode right = getLowestCommonAncestorWithRecursion(root.right, t1, t2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        process(root, fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = t1;
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(root);

        cur = t2;
        while (cur != fatherMap.get(cur)) {
            if (!set1.add(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return null;
    }

    private static void process(TreeNode node, HashMap<TreeNode, TreeNode> fatherMap) {
        if (node == null) {
            return;
        }
        fatherMap.put(node.left, node);
        fatherMap.put(node.right, node);
        process(node.left, fatherMap);
        process(node.right, fatherMap);
    }
}