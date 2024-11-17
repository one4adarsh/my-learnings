package org.example.part_3_data_structures_and_algorithms._6_graph;

import java.util.ArrayList;

public class GraphOperations extends GraphConstructor {

    public void addVertex(String vertex) {
        /*
         * adjList.computeIfAbsent(vertex, k -> new ArrayList<>());
         */
        if (adjList.get(vertex) == null) {
            System.out.println("Add Vertex: " + vertex);
            adjList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            System.out.println("Add Edge: " + vertex1 + " -> " + vertex2);
            adjList.get(vertex1).add(vertex2);
            System.out.println("Add Edge: " + vertex2 + " -> " + vertex1);
            adjList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            System.out.println("Remove Edge: " + vertex1 + " -> " + vertex2);
            adjList.get(vertex1).remove(vertex2);
            System.out.println("Remove Edge: " + vertex2 + " -> " + vertex1);
            adjList.get(vertex2).remove(vertex1);
        }
    }

    public void removeNode(String vertex) {
        if (adjList.get(vertex) == null) {
            System.out.println("Vertex not found");
        } else {
            System.out.println("Remove Vertex: " + vertex);
            for (String otherVertex : adjList.get(vertex)) {
                adjList.get(otherVertex).remove(vertex);
            }
            adjList.remove(vertex);
        }


    }
}
