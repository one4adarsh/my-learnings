package org.example.part_3_data_structures_and_algorithms._10_tree_traversal._1_BreadthFirstSearch;

import org.example.part_3_data_structures_and_algorithms._5_binary_search_tree.BSTOperations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends BSTOperations {

    public ArrayList<Integer> breadthFirstSearch() {
        NodeBST currentNode = root;
        Queue<NodeBST> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }
}
