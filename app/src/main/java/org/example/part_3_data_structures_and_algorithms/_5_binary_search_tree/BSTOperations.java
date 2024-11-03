package org.example.part_3_data_structures_and_algorithms._5_binary_search_tree;

public class BSTOperations extends BSTConstructor {

    public void insert(int value) {
        NodeBST newNodeBST = new NodeBST(value);
        NodeBST temp = root;
        if (temp == null) {
            root = newNodeBST;
        } else {
            while (true) {
                // 1. Check duplicate
                if (value == temp.value) {
                    System.out.println("Value already exists");
                }

                // 2. Check - less or greater
                if (value < temp.value) { // if less - choose left
                    // 3. check - left is empty or not
                    if (temp.left == null) { // if empty - insert
                        temp.left = newNodeBST;
                        break;
                    } else { // if not - move to next level - reset temp
                        temp = temp.left;
                    }
                } else { // if greater - choose right
                    // 3. check - right is empty or not
                    if (temp.right == null) { // if empty - insert
                        temp.right = newNodeBST;
                        break;
                    } else { // if not - move to next level - reset temp
                        temp = temp.right;
                    }
                }
            }
        }
    }

    public void contains(int value) {
        NodeBST temp = root;
        int flag = 0;
        if (temp == null) {
            System.out.println("Not found");
        } else {
            while (temp != null) {
                if (value < temp.value) {
                    temp = temp.left;
                } else if (value > temp.value) {
                    temp = temp.right;
                } else {
                    flag = 1;
                    System.out.println("Value found: " + value);
                    break;
                }
            }
            if (flag == 0) System.out.println("Value not found: " + value);
        }
    }
}
