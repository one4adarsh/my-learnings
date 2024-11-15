package org.example.part_3_data_structures_and_algorithms._1_linked_list;

public class LLConstructor {
    public class NodeLL {
        public int value;
        public NodeLL next;

        NodeLL(int value) {
            this.value = value;
        }
    }

    NodeLL head;
    NodeLL tail;
    int length;

    LLConstructor(int value) {
        NodeLL newNode = new NodeLL(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        System.out.println(head.value);
    }

    public void getTail() {
        System.out.println(tail.value);
    }

    public void getLength() {
        System.out.println(length);
    }

    public void printList() {
        NodeLL temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
