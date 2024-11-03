package org.example.part_3_data_structures_and_algorithms._5_binary_search_tree;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>> Binary Search Tree <<<<<");
        System.out.println();
        System.out.println("BST Constructor - initialised with root as null");
        BSTConstructor myBST = new BSTConstructor();
        System.out.println("Root: " + myBST.root);
        System.out.println();

        BSTOperations myBSTOperations = new BSTOperations();

        System.out.println("BST Insert");
        myBSTOperations.insert(12);
        myBSTOperations.insert(11);
        myBSTOperations.insert(13);

        System.out.println("Root: " + myBSTOperations.root.value);
        System.out.println("Root->Left: " + myBSTOperations.root.left.value);
        System.out.println("Root->Right: " + myBSTOperations.root.right.value);
        System.out.println();

        System.out.println("BST Contains");
        myBSTOperations.contains(13);
    }
}
