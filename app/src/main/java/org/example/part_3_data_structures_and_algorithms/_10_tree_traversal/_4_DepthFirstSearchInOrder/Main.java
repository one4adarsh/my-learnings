package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._4_DepthFirstSearchInOrder;

public class Main {
    public static void main(String[] args) {
        DepthFirstSearchInOrder myDFSInOrder = new DepthFirstSearchInOrder();

        System.out.println("Depth First Search - PostOrder");
        myDFSInOrder.insert(47);
        myDFSInOrder.insert(21);
        myDFSInOrder.insert(76);
        myDFSInOrder.insert(18);
        myDFSInOrder.insert(27);
        myDFSInOrder.insert(52);
        myDFSInOrder.insert(82);

        System.out.println(myDFSInOrder.DFSInOrder());
    }
}
