package org.example.part_3_data_structures_and_algorithms._2_doubly_linked_list;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>> Doubly Linked List <<<<<");
        System.out.println();
        System.out.println("DLL Constructor");
        DLLConstructor dllConstructor = new DLLConstructor(5);
        System.out.print("Head: ");
        dllConstructor.getHead();
        System.out.print("Tail: ");
        dllConstructor.getTail();
        System.out.print("Length: ");
        dllConstructor.getLength();
        dllConstructor.printList();
        System.out.println();

        System.out.println("DLL Operations");
        DLLOperations myDLL = new DLLOperations(5);
        myDLL.append(7);
        myDLL.append(13);
        System.out.println();

        myDLL.removeLast();
        myDLL.removeLast();
        myDLL.removeLast();
        myDLL.removeLast();
        System.out.println();

        myDLL.prepend(2);
        myDLL.prepend(1);
        myDLL.prepend(0);
        System.out.println();

        myDLL.removeFirst();
        myDLL.removeFirst();
        myDLL.removeFirst();
        myDLL.removeFirst();
        System.out.println();

        myDLL.append(33);
        myDLL.append(34);
        myDLL.append(35);
        myDLL.printList();
        myDLL.getLength();
        System.out.println();

        myDLL.get(1);
        System.out.println();

        myDLL.set(2, 43);
        myDLL.printList();
        System.out.println();

        myDLL.insert(0, 0);
        myDLL.insert(2, 0);
        myDLL.insert(5, 0);
        myDLL.printList();
        System.out.println();

        myDLL.remove(5);
        myDLL.remove(2);
        myDLL.remove(0);
        myDLL.printList();
        System.out.println();
    }
}
