/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.tree;

import com.lyw.leetCode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pangu
 * @version : SerializeAndReconstructTree.java, v 0.1 2022年04月25日 下午11:48 pangu Exp $
 */
public class SerializeAndReconstructTree {
    public static void main(String[] args) {

    }

    /**
     * 序列化
     * #代表null，_代表结束
     * @param root
     * @return
     */
    private static String serializeByPreOrder(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serializeByPreOrder(root.left);
        res += serializeByPreOrder(root.right);
        return res;
    }

    private static TreeNode reconByPreString(String s) {
        String[] values = s.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreorder(queue);
    }

    private static TreeNode reconPreorder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = reconPreorder(queue);
        root.right = reconPreorder(queue);
        return root;
    }
}