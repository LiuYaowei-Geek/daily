/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.graph;


import com.lyw.leetCode.model.Graph;
import com.lyw.leetCode.model.GraphNode;

import java.util.*;

/**
 * @author pangu
 * @version : SortedTopology.java, v 0.1 2022年04月26日 下午6:16 pangu Exp $
 */
public class SortedTopology {
    public static void main(String[] args) {

    }

    private static List<GraphNode> sortedTopology(Graph graph) {
        //key-某一个node， value-剩余的入度
        HashMap<GraphNode, Integer> inMap = new HashMap<>();
        //入度为0的节点才能进队列
        Queue<GraphNode> zeroInQueue = new LinkedList<>();

        for (GraphNode node : graph.graphNodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓补排序的结果，依次添加
        List<GraphNode> res = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            GraphNode cur = zeroInQueue.poll();
            res.add(cur);
            for (GraphNode next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    res.add(next);
                }
            }
        }
        return res;
    }
}