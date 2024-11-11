package org.example.part_3_data_structures_and_algorithms._4_hash_table;

public class HTConstructor {
    int size = 7;
    NodeHT[] dataMap;

    public class NodeHT {
        public String key;
        public int value;
        NodeHT next;

        public NodeHT(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HTConstructor() {
        this.dataMap = new NodeHT[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ": ");
            NodeHT temp = dataMap[i];
            while (temp != null) {
                System.out.println("{" + temp.key + ": " + temp.value + "}");
                temp = temp.next;
            }
        }
        System.out.println();
    }
}
