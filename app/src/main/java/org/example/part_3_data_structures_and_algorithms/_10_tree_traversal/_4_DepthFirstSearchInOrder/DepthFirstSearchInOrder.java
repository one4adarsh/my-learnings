package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._4_DepthFirstSearchInOrder;

import org.example.part_3_data_structures_and_algorithms._5_binary_search_tree.BSTOperations;

import java.util.ArrayList;

public class DepthFirstSearchInOrder extends BSTOperations {

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(NodeBST currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }
}
