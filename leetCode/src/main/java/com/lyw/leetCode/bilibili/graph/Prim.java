/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.graph;


import com.lyw.leetCode.model.Graph;
import com.lyw.leetCode.model.GraphEdge;
import com.lyw.leetCode.model.GraphNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author pangu
 * @version : Prim.java, v 0.1 2022年04月26日 下午7:23 pangu Exp $
 */
public class Prim {
    public static void main(String[] args) {

    }

    private static class GraphEdgeComparator implements Comparator<GraphEdge> {

        @Override
        public int compare(GraphEdge o1, GraphEdge o2) {
            return o1.weight - o2.weight;
        }
    }

    private static Set<GraphEdge> primMST(Graph graph) {
        //解锁的边进入小根堆
        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(new GraphEdgeComparator());
        HashSet<GraphNode> set = new HashSet<>();
        Set<GraphEdge> res = new HashSet<>();
        //随便挑了一个点
        for (GraphNode node : graph.graphNodes.values()) {
            //node 是起始点
            if (!set.contains(node)) {
                set.add(node);
                //由一个点解锁所以相连的边
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    //弹出解锁边中最小的边
                    GraphEdge edge = priorityQueue.poll();
                    //可能的一个新的节点
                    GraphNode toNode = edge.to;
                    //不含有的时候就是新的点
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        res.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return res;
    }
}