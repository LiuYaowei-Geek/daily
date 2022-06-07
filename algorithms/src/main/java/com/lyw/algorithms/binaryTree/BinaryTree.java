package com.lyw.algorithms.binaryTree;

import java.util.Stack;

public class BinaryTree {

    public TreeNode root;

    BinaryTree (int[] array, int index) {
        root = createBinaryTree(array, index);
    }

    /**
     * 创建完全二叉树
     *
     * @param array
     * @param index
     * @return
     */
    private TreeNode createBinaryTree(int[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+2
            treeNode.left = createBinaryTree(array, 2 * index + 1);
            treeNode.right = createBinaryTree(array, 2 * index + 2);
        }
        return treeNode;
    }

    private void showData(TreeNode node) {
        System.out.print(node);
    }

    /**
     * 递归先序遍历
     *
     * @param node
     */
    private void preOrder(TreeNode node) {
        if (null != node) {
            showData(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (null != node) {
            inOrder(node.left);
            showData(node);
            inOrder(node.right);
        }
    }

    /**
     * 递归后序遍历
     *
     * @param node
     */
    private void postOrder(TreeNode node) {
        if (null != node) {
            postOrder(node.left);
            postOrder(node.right);
            showData(node);
        }
    }

    /**
     * 非递归先序遍历
     *
     * @param node
     */
    private void noRecursionPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (null != node) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                showData(node);
                if (null != node.right) {
                    stack.push(node.right);
                }
                if (null != node.left) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 非递归中序遍历
     * 1、循环将全部左节点入栈
     * 2、循环将栈中元素弹出，并将节点指向右节点
     * 3、节点非空，入栈，节点指向其左节点
     * 4、栈非空，弹出元素
     *
     * @param node
     */
    private void noRecursionInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (null != p || stack.size() > 0) {
            while (null != p) {
                stack.push(p);
                p = p.left;
            }
            if (stack.size() > 0) {
                p = stack.pop();
                showData(p);
                p = p.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     *1、将左节点循环入栈
     * 2、
     * @param node
     */
    private void noRecursionPostOrder(TreeNode node) {
        TreeNode pre = node;
        Stack<TreeNode> stack = new Stack<>();
        while (null != node) {
            for (; null != node.left; node = node.left) {
                stack.push(node);
            }
            while (null != node && (null == node.right || node.right == pre)) {
                showData(node);
                pre = node;
                if (stack.empty()) {
                    return;
                }
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
    }

    /**
     * 树结构
     *     1
     *   2   3
     *  4 5 6 7
     * 8 9
     * @param args
     */
    public static void main(String[] args) {
        //顺序存储的满二叉树或者完全二叉树
        int[] arr={1,2,3,4,5,6,7,8,9};
        BinaryTree bt=new BinaryTree(arr, 0);
        System.out.println("递归前序遍历：");
        bt.preOrder(bt.root);
        System.out.println();
        System.out.println("非递归前序遍历：");
        bt.noRecursionPreOrder(bt.root);
        System.out.println();
        System.out.println("递归中序遍历：");
        bt.inOrder(bt.root);
        System.out.println();
        System.out.println("非递归中序遍历：");
        bt.noRecursionInOrder(bt.root);
        System.out.println();
        System.out.println("递归后序遍历：");
        bt.postOrder(bt.root);
        System.out.println();
        System.out.println("非递归后序遍历：");
        bt.noRecursionPostOrder(bt.root);
    }
}
