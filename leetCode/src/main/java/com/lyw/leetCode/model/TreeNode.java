package com.lyw.leetCode.model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode parent;


    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 构造默认二叉树
     * @return
     */
    public static TreeNode buildDefaultTreeNode() {
        /**
         * 二叉树：
         *    1
         *  2   3
         * 4 5 6 7
         * 先序：1 2 4 5 3 6 7
         * 中序：4 2 5 1 6 3 7
         * 后序：4 5 2 6 7 3 1
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
