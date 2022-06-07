package com.lyw.leetCode.model;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, GraphNode> graphNodes;
    public HashSet<GraphEdge> graphEdges;

    public Graph() {
        graphNodes = new HashMap<>();
        graphEdges = new HashSet<>();
    }
}
