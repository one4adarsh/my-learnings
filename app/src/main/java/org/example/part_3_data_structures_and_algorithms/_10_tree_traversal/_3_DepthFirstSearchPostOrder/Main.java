package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._3_DepthFirstSearchPostOrder;

public class Main {
    public static void main(String[] args) {
        DepthFirstSearchPostOrder myDFSPostOrder = new DepthFirstSearchPostOrder();

        System.out.println("Depth First Search - PostOrder");
        myDFSPostOrder.insert(47);
        myDFSPostOrder.insert(21);
        myDFSPostOrder.insert(76);
        myDFSPostOrder.insert(18);
        myDFSPostOrder.insert(27);
        myDFSPostOrder.insert(52);
        myDFSPostOrder.insert(82);

        System.out.println(myDFSPostOrder.DFSPostOrder());
    }
}
