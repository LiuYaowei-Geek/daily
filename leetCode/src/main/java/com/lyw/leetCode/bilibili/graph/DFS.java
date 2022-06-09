/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.graph;


import com.lyw.leetCode.model.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author pangu
 * @version : DFS.java, v 0.1 2022年04月26日 下午1:58 pangu Exp $
 */
public class DFS {
    public static void main(String[] args) {

    }

    //深度优先遍历
    private static void dfs(GraphNode node) {
        if (node == null) {
            return;
        }
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            GraphNode cur = stack.pop();
            for (GraphNode next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }
}