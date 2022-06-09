package com.lyw.leetCode.hot100;
//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return the ordering of courses you should take to finish all courses. If ther
//e are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 6348 👎 231

import java.util.*;

/**
  * questionId：210
  * question：Course Schedule II
  * date：2022-03-25 17:47:41
*/
public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * This question asks for an order in which prerequisite courses must be taken first. This prerequisite relationship reminds one of directed graphs. Then, the problem reduces to find a topological sort order of the courses, which would be a DAG if it has a valid order.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        //return solveByBFS(incLinkCounts, adjs);
        return solveByDFS(adjs);
    }

    /**
     * The first step is to transform it into a directed graph. Since it is likely to be sparse,we use adjacency list graph data structure. 1 -> 2 means 1 must be taken before 2.
     * @param incLinkCounts
     * @param adjs
     * @param prerequisites
     */
    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0) { adjs.add(new ArrayList<>()); }
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    /**
     * How can we obtain a topological sort order of a DAG?
     *
     * We observe that if a node has incoming edges, it has prerequisites. Therefore, the first few in the order must be those with
     * no prerequisites, i.e. no incoming edges. Any non-empty DAG must have at least one node without incoming links. You can draw a
     * small graph to convince yourself. If we visit these few and remove all edges attached to them, we are left with a smaller DAG,
     * which is the same problem. This will then give our BFS solution.
     * @param incLinkCounts
     * @param adjs
     * @return
     */
    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) { toVisit.offer(i); }
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) { toVisit.offer(to); }
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }

    /**
     * Another way to think about it is the last few in the order must be those which are not prerequisites of other courses. Thinking it recursively means if one node has unvisited child node, you should visit them first before you put this node down in the final order array. This sounds like the post-order of a DFS. Since we are putting nodes down in the reverse order, we should reverse it back to correct ordering or use a stack.
     * @param adjs
     * @return
     */
    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet hasCycle = new BitSet(1);
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {
            if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) { return new int[0]; }
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) { orderArray[i] = order.pop(); }
        return orderArray;
    }

    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (visited.get(to) == false) {
                if (hasOrder(to, adjs, visited, onStack, order) == false) { return false; }
            } else if (onStack.get(to) == true) {
                return false;
            }
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
