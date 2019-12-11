package com.example.kodemo;

import java.util.*;

public class DFSOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    DFSOrder(DirectGraph graph) {
        marked = new boolean[graph.getV()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(DirectGraph graph, Integer v) {
        marked[v] = true;
        pre.add(v);
        for (Integer w : graph.getAdj()[v]) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public List<Integer> getReversePost() {
        List<Integer> list = new ArrayList<>();
        while (!reversePost.empty()) {
            list.add(reversePost.pop());
        }
        return list;
    }
}