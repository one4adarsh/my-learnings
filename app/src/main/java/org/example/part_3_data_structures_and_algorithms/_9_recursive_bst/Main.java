package org.example.part_3_data_structures_and_algorithms._9_recursive_bst;

public class Main {
    public static void main(String[] args) {
        RBSTOperations myRBST = new RBSTOperations();
        System.out.println("BST Insert");
        myRBST.rInsert(2);
        myRBST.rInsert(1);
        myRBST.rInsert(3);

        System.out.println("Root: " + myRBST.root.value);
        System.out.println("Root->Left: " + myRBST.root.left.value);
        System.out.println("Root->Right: " + myRBST.root.right.value);
        System.out.println();

        System.out.println("BST Contains");
        System.out.println(myRBST.rContains(3));

        System.out.println("BST Contains");
        myRBST.rDeleteNode(2);
        System.out.println("Root: " + myRBST.root.value);
        System.out.println("Root->Left: " + myRBST.root.left.value);
        System.out.println("Root->Right: " + myRBST.root.right);
        System.out.println();
    }
}
