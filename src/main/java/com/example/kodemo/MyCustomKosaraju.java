package com.example.kodemo;

import java.util.Collections;
import java.util.List;

public class MyCustomKosaraju {
    private boolean[] marked;
    private int[] id;
    private int count;

    MyCustomKosaraju(DirectGraph graph) {
        DFSOrder dfsOrder = new DFSOrder(graph);
        List<Integer> reversePost = dfsOrder.getReversePost();
        Collections.reverse(reversePost);
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