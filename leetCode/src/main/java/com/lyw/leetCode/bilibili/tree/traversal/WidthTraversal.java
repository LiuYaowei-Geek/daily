/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.tree.traversal;


import com.lyw.leetCode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pangu
 * @version : WidthTraversal.java, v 0.1 2022年04月24日 下午11:18 pangu Exp $
 */
public class WidthTraversal {
    public static void main(String[] args) {
        System.out.println(widthTraversal(TreeNode.buildDefaultTreeNode(), new StringBuilder()));

    }

    /**
     * 宽度遍历
     * 1. 头节点进队列
     * 2. 队列弹出cur并处理(打印)
     * 3. cur左节点进队列，cur右节点进队列，如果存在的话
     * 4. 重复2 3
     *
     * @param root
     * @param sb
     * @return
     */
    private static String widthTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            sb.append(cur.val).append(" ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return sb.toString();
    }
}