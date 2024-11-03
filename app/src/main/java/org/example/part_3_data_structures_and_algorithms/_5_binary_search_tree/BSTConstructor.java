package org.example.part_3_data_structures_and_algorithms._5_binary_search_tree;

public class BSTConstructor {
    public NodeBST root;

    public class NodeBST {
        public int value;
        public NodeBST left;
        public NodeBST right;

        public NodeBST(int value) {
            this.value = value;
        }
    }
}
