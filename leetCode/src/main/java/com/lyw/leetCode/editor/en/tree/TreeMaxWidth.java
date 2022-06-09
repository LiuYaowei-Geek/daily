/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.editor.en.tree;

import com.lyw.leetCode.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pangu
 * @version : TreeMaxWidth.java, v 0.1 2022年04月24日 下午11:35 pangu Exp $
 */
public class TreeMaxWidth {
    public static void main(String[] args) {
        System.out.println(getTreeMaxWidth(TreeNode.buildDefaultTreeNode()));
    }

    /**
     * 树的最大宽度
     * @param root
     * @return
     */
    private static int getTreeMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);
        int curLevel = 1;
        int curLevelNodeNum = 0;
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodeNum++;
            } else {
                maxWidth = Math.max(maxWidth, curLevelNodeNum);
                curLevel++;
                curLevelNodeNum = 1;
            }
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return Math.max(maxWidth, curLevelNodeNum);
    }
}