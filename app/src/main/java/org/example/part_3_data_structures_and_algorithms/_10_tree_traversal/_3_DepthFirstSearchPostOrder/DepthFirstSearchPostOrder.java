package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._3_DepthFirstSearchPostOrder;

import org.example.part_3_data_structures_and_algorithms._5_binary_search_tree.BSTOperations;

import java.util.ArrayList;

public class DepthFirstSearchPostOrder extends BSTOperations {

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(NodeBST currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }
}
