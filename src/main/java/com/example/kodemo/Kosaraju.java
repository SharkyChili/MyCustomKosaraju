package com.example.kodemo;

import java.util.List;

public class Kosaraju {
    private boolean[] marked;
    private int[] id;
    private int count;

    Kosaraju(DirectGraph graph) {
        DFSOrder reverseGraphDfsOrder = new DFSOrder(graph.reverse());
        List<Integer> reversePost = reverseGraphDfsOrder.getReversePost();
        marked = new boolean[graph.getV()];
        id = new int[graph.getV()];
        count = 0;
        for (Integer v : reversePost) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(DirectGraph graph, Integer v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : graph.getAdj()[v]) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public int[] getId() {
        return id;
    }
}