package org.example.part_3_data_structures_and_algorithms._3_stack_and_queue;

public class StackOperations extends StackConstructor {
    StackOperations(int value) {
        super(value);
    }

    public void push(int value) {
        System.out.println("Push: " + value);
        NodeStack newNode = new NodeStack(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public void pop() {
        if (height == 0) {
            System.out.println("Empty Stack");
        } else {
            System.out.println("Pop: " + top.value);
            NodeStack temp = top;
            top = temp.next;
            temp.next = null;
            height--;
        }
    }
}
