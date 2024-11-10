package org.example.part_3_data_structures_and_algorithms._9_recursive_bst;

import org.example.part_3_data_structures_and_algorithms._5_binary_search_tree.BSTConstructor;

public class RBSTOperations extends BSTConstructor {

    public void rInsert(int value) {
        if (root == null) root = new NodeBST(value);
        this.rInsert(root, value);
    }

    private NodeBST rInsert(NodeBST currentNode, int value) {
        if (currentNode == null) return new NodeBST(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public boolean rContains(int value) {
        return this.rContains(root, value);
    }

    private boolean rContains(NodeBST currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public int minValue(NodeBST currentNode) {
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void rDeleteNode(int value) {
        this.rDeleteNode(root, value);
    }

    private NodeBST rDeleteNode(NodeBST currentNode, int value) {
        if(currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = rDeleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rDeleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = rDeleteNode(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }
}
