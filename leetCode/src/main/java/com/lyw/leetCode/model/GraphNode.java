package com.lyw.leetCode.model;

import java.util.ArrayList;

public class GraphNode {
    public int val;
    public int in;
    public int out;
    public ArrayList<GraphNode> nexts;
    public ArrayList<GraphEdge> edges;

    public GraphNode(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList();
    }
}
