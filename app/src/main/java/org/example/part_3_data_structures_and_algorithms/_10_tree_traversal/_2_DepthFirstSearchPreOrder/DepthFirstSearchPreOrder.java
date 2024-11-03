package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._2_DepthFirstSearchPreOrder;

import org.example.part_3_data_structures_and_algorithms._5_binary_search_tree.BSTOperations;

import java.util.ArrayList;

public class DepthFirstSearchPreOrder extends BSTOperations {

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(NodeBST currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

}
