package com.example.kodemo;

import java.util.HashSet;
import java.util.Set;

public class DirectGraph {
    private int v;
    private int e;
    private Set<Integer>[] adj;

    DirectGraph(Integer v) {
        this.v = v;
        this.e = 0;
        this.adj = (HashSet<Integer>[]) new HashSet[v];
        for (Integer i = 0; i < v; i++) {
            this.adj[i] = new HashSet<Integer>();
        }
    }

    public void addEdge(Integer v, Integer w) {
        this.adj[v].add(w);
        this.e++;
    }

    public DirectGraph reverse() {
        DirectGraph graph = new DirectGraph(this.v);
        for (int v = 0; v < this.v; v++) {
            for (Integer w : this.adj[v]) {
                graph.addEdge(w, v);
            }
        }
        return graph;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public Set<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(Set<Integer>[] adj) {
        this.adj = adj;
    }
}
