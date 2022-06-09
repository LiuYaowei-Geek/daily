/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;


import com.lyw.leetCode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树，使用宽度遍历，每层从左到右按顺序排列。
 *
 * 完全二叉树区别于满二叉树，完全二叉树可以有一个节点有左无右
 *
 * 1. 任一节点，有右无左，直接false
 * 2. 在满足条件1时，如果遇到了第一个左右孩子不全的节点，后续遍历到的节点都应该是叶子节点，不能有孩子
 * @author pangu
 * @version : CheckCBT.java, v 0.1 2022年04月25日 下午9:07 pangu Exp $
 */
public class CheckCBT {

    public static void main(String[] args) {

    }

    private static boolean checkCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //是否遇到左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            //遇到过左右两个孩子不双全的节点，并且当前节点不是叶节点
            if ((leaf && (l != null || r != null))
                    //有右无左。左节点为空，但是右节点不为空
                    || (l == null || r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }

            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

}