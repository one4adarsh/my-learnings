package org.example.part_3_data_structures_and_algorithms._6_graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphConstructor {
    public HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }
}
