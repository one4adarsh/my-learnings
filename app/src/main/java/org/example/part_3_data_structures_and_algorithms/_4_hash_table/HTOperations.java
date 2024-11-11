package org.example.part_3_data_structures_and_algorithms._4_hash_table;

import java.util.ArrayList;
import java.util.Objects;

public class HTOperations extends HTConstructor {
    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % size;
        }
        return hash;
    }

    public void set(String key, int value) {
        NodeHT newNode = new NodeHT(key, value);
        int index = this.hash(key);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            NodeHT temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void get(String key) {
        int index = this.hash(key);
        boolean flag = false;
        NodeHT temp = dataMap[index];
        while (temp != null) {
            if (Objects.equals(temp.key, key)) {
                System.out.print("Found: ");
                System.out.println("{" + temp.key + ": " + temp.value + "}");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("Not Found: " + key);
        }
    }

    public void getAllKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (NodeHT nodeHT : dataMap) {
            NodeHT temp = nodeHT;
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        System.out.println(keys);
    }
}
