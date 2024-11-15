package org.example.part_3_data_structures_and_algorithms._2_doubly_linked_list;

public class DLLConstructor {
    public class NodeDLL {
        public int value;
        public NodeDLL next;
        public NodeDLL prev;

        public NodeDLL(int value) {
            this.value = value;
        }
    }

    NodeDLL head;
    NodeDLL tail;
    int length;

    DLLConstructor(int value) {
        NodeDLL newNode = new NodeDLL(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        System.out.println(head.value);
        ;
    }

    public void getTail() {
        System.out.println(tail.value);
        ;
    }

    public void getLength() {
        System.out.println(length);
        ;
    }

    public void printList() {
        NodeDLL temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
