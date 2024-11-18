package org.example.part_3_data_structures_and_algorithms._3_stack_and_queue;

public class QueueOperations extends QueueConstructor {
    QueueOperations(int value) {
        super(value);
    }

    public void enqueue(int value) {
        System.out.println("Enqueue: " + value);
        NodeQueue newNode = new NodeQueue(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void dequque() {
        if (length == 0) {
            System.out.println("Empty Queue");
        } else if (length == 1) {
            System.out.println("Dequeue: " + first.value);
            first = null;
            last = null;
            length = 0;
        } else {
            System.out.println("Dequeue: " + first.value);
            NodeQueue temp = first;
            first = first.next;
            temp.next = null;
            length--;
        }
    }
}
