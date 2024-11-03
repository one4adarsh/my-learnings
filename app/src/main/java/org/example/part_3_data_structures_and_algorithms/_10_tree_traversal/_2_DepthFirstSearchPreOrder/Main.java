package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._2_DepthFirstSearchPreOrder;

public class Main {
    public static void main(String[] args) {
        DepthFirstSearchPreOrder myDFSPreOrder = new DepthFirstSearchPreOrder();

        System.out.println("Depth First Search - PreOrder");
        myDFSPreOrder.insert(47);
        myDFSPreOrder.insert(21);
        myDFSPreOrder.insert(76);
        myDFSPreOrder.insert(18);
        myDFSPreOrder.insert(27);
        myDFSPreOrder.insert(52);
        myDFSPreOrder.insert(82);

        System.out.println(myDFSPreOrder.DFSPreOrder());
    }
}
