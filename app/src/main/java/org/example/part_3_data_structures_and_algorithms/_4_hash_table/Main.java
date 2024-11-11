package org.example.part_3_data_structures_and_algorithms._4_hash_table;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>> Hash Table <<<<<");
        System.out.println();
        System.out.println("HT Constructor - empty");
        HTConstructor myHTConstructor = new HTConstructor();
        myHTConstructor.printTable();

        HTOperations myHT = new HTOperations();
        System.out.println("HT Set");
        myHT.set("nails", 100);
        myHT.set("screws", 123);
        myHT.set("bolts", 231);
        myHT.set("lumber", 421);
        myHT.printTable();

        System.out.println("HT Get");
        myHT.get("hello");
        myHT.get("lumber");
        System.out.println();

        System.out.println("HT All Keys");
        myHT.getAllKeys();
    }
}
