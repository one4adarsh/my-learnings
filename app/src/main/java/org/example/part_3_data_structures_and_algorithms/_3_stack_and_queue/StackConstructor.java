package org.example.part_3_data_structures_and_algorithms._3_stack_and_queue;

public class StackConstructor {
    public class NodeStack {
        int value;
        NodeStack next;

        NodeStack(int value) {
            this.value = value;
        }
    }

    public NodeStack top;
    public int height;

    StackConstructor(int value) {
        top = new NodeStack(value);
        height = 1;
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void printStack() {
        System.out.print("Stack: ");
        NodeStack temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
