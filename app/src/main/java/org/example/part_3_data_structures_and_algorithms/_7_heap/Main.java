package org.example.part_3_data_structures_and_algorithms._7_heap;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>> Heap <<<<<");
        System.out.println();

        System.out.println("-------Heap 1-------");
        HeapOperations myHeap = new HeapOperations();

        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);

        System.out.println(myHeap.getHeap() + "\n");

        System.out.println("Heap Insert: 100");
        myHeap.insert(100);
        System.out.println(myHeap.getHeap());

        System.out.println("Heap Insert: 75");
        myHeap.insert(75);
        System.out.println(myHeap.getHeap());
        System.out.println();


        System.out.println("-------Heap 2-------");
        HeapOperations myHeap2 = new HeapOperations();
        myHeap2.insert(95);
        myHeap2.insert(75);
        myHeap2.insert(80);
        myHeap2.insert(55);
        myHeap2.insert(60);
        myHeap2.insert(50);
        myHeap2.insert(65);
        System.out.println(myHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myHeap2.remove());
        System.out.println(myHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myHeap2.remove());
        System.out.println(myHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myHeap2.remove());
        System.out.println(myHeap2.getHeap() + "\n");


        System.out.println("-------Heap 3-------");
        HeapOperations myMinHeap = new HeapOperations();

        myMinHeap.insertMinHeap(99);
        myMinHeap.insertMinHeap(72);
        myMinHeap.insertMinHeap(61);
        myMinHeap.insertMinHeap(58);

        System.out.println(myMinHeap.getHeap() + "\n");

        System.out.println("Heap Insert: 10");
        myMinHeap.insertMinHeap(10);
        System.out.println(myMinHeap.getHeap());

        System.out.println("Heap Insert: 65");
        myMinHeap.insertMinHeap(65);
        System.out.println(myMinHeap.getHeap());
        System.out.println();


        System.out.println("-------Heap 4-------");
        HeapOperations myMinHeap2 = new HeapOperations();
        myMinHeap2.insertMinHeap(5);
        myMinHeap2.insertMinHeap(15);
        myMinHeap2.insertMinHeap(20);
        myMinHeap2.insertMinHeap(35);
        myMinHeap2.insertMinHeap(40);
        myMinHeap2.insertMinHeap(50);
        System.out.println(myMinHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myMinHeap2.removeMinHeap());
        System.out.println(myMinHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myMinHeap2.removeMinHeap());
        System.out.println(myMinHeap2.getHeap() + "\n");

        System.out.println("Heap Remove: " + myMinHeap2.removeMinHeap());
        System.out.println(myMinHeap2.getHeap() + "\n");
    }
}
