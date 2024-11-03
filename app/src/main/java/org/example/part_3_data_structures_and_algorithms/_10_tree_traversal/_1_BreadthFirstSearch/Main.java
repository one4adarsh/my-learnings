package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._1_BreadthFirstSearch;

public class Main {
    public static void main(String[] args) {
        BreadthFirstSearch myBFS = new BreadthFirstSearch();

        System.out.println("Breadth First Search");
        myBFS.insert(47);
        myBFS.insert(21);
        myBFS.insert(76);
        myBFS.insert(18);
        myBFS.insert(27);
        myBFS.insert(52);
        myBFS.insert(82);

        System.out.println(myBFS.breadthFirstSearch());
    }
}
