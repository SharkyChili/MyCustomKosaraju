package com.example.kodemo;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        DirectGraph graph1 = getGraph();
        //long time1 = System.nanoTime();
        int[] id1 = new Kosaraju(graph1).getId();
        System.out.println("Kosaraju");
        printId(id1);
        //System.out.println((System.nanoTime() - time1));
        DirectGraph graph2 = getGraph();
        //long time2 = System.nanoTime();
        int[] id2 = new MyCustomKosaraju(graph2).getId();
        System.out.println("MyCustomKosaraju");
        printId(id2);
        //System.out.println((System.nanoTime() - time2));
        arrayEquals(id1, id2);
    }

    private static void arrayEquals(int[] id1, int[] id2) {
        if (id1.length == id2.length) {
            boolean equals = true;
            for (int index = 0; index < id1.length; index++) {
                if (id1[index] != id2[index]) {
                    System.out.println("result equal : no");
                    equals = false;
                    break;
                }
            }
            if (equals) {
                System.out.println("result equal : yes");
            }
        } else {
            System.out.println("result equal : no");
        }
    }

    private static void printId(int[] id) {
        List<Stack<Integer>> list = new ArrayList<>();
        for (int index = 0; index < id.length; index++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(index);
            stack.push(id[index]);
            list.add(stack);
        }
        Map<Integer, HashSet<Integer>> collect = list.stream().collect(Collectors.groupingBy(Stack::pop, Collectors.mapping(Stack::pop, Collectors.toCollection(HashSet::new))));
        System.out.println(collect);
    }

    private static DirectGraph getGraph() {
        DirectGraph graph = new DirectGraph(13);
        graph.addEdge(6, 0);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);
        graph.addEdge(6, 9);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);
        graph.addEdge(10, 12);
        graph.addEdge(12, 9);
        graph.addEdge(9, 11);
        graph.addEdge(11, 12);
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(0, 5);
        graph.addEdge(3, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 2);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(11, 4);
        return graph;
    }
}