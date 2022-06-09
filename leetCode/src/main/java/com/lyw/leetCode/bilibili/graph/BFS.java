/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.graph;


import com.lyw.leetCode.model.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的宽度遍历
 *
 * @author pangu
 * @version : BFS.java, v 0.1 2022年04月26日 下午1:47 pangu Exp $
 */
public class BFS {
    public static void main(String[] args) {

    }

    //从node出发对图进行宽度优先遍历
    private static void bfs(GraphNode node) {
        if (node == null) {
            return;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            System.out.println(cur.val);
            for (GraphNode next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}