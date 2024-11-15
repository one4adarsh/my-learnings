package org.example.part_3_data_structures_and_algorithms._1_linked_list;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>> Linked List <<<<<");
        System.out.println();
        System.out.println("LL Constructor");
        LLConstructor llConstructor = new LLConstructor(5);
        System.out.print("Head: ");
        llConstructor.getHead();
        System.out.print("Tail: ");
        llConstructor.getTail();
        System.out.print("Length: ");
        llConstructor.getLength();
        llConstructor.printList();
        System.out.println();

        System.out.println("LL Operations");
        LLOperations myLL = new LLOperations(5);
        myLL.append(6);
        myLL.append(7);
        System.out.println();

        myLL.removeLast();
        myLL.removeLast();
        myLL.removeLast();
        myLL.removeLast();
        System.out.println();

        myLL.prepend(2);
        myLL.prepend(1);
        myLL.prepend(0);
        System.out.println();

        myLL.removeFirst();
        myLL.removeFirst();
        myLL.removeFirst();
        myLL.removeFirst();
        System.out.println();

        myLL.append(33);
        myLL.append(34);
        myLL.append(35);
        myLL.printList();
        myLL.getLength();
        System.out.println();

        myLL.get(1);
        System.out.println();

        myLL.set(2, 43);
        myLL.printList();
        System.out.println();

        myLL.insert(0, 0);
        myLL.insert(2, 0);
        myLL.insert(5, 0);
        myLL.printList();
        System.out.println();

        myLL.remove(5);
        myLL.remove(2);
        myLL.remove(0);
        myLL.printList();
        System.out.println();

        myLL.reverse();
    }
}
