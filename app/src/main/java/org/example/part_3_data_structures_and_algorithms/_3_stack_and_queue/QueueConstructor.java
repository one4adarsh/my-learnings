package org.example.part_3_data_structures_and_algorithms._3_stack_and_queue;

public class QueueConstructor {
    public class NodeQueue {
        int value;
        NodeQueue next;

        NodeQueue(int value) {
            this.value = value;
        }
    }


    NodeQueue first; // exit point
    NodeQueue last; // entry point
    int length;

    QueueConstructor(int value) {
        NodeQueue newNode = new NodeQueue(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printQueue() {
        NodeQueue temp = first;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
