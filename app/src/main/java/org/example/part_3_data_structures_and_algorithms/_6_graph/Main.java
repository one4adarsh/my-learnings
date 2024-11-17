package org.example.part_3_data_structures_and_algorithms._6_graph;

public class Main {
    public static void main(String[] args) {
        GraphOperations myGraph = new GraphOperations();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("C", "A");

        myGraph.printGraph();
        System.out.println();

        myGraph.removeEdge("A", "B");
        myGraph.printGraph();
        System.out.println();

        myGraph.removeNode("B");
        myGraph.printGraph();
    }
}
