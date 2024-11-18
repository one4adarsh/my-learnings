package org.example.part_3_data_structures_and_algorithms._3_stack_and_queue;

public class Main {
    public static void main(String[] args) {
        StackConstructor myStackConstructor = new StackConstructor(4);
        myStackConstructor.getTop();
        myStackConstructor.getHeight();
        myStackConstructor.printStack();
        System.out.println();

        StackOperations myStack = new StackOperations(5);
        myStack.push(6);
        myStack.push(7);
        myStack.printStack();
        System.out.println();

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.printStack();
        System.out.println();

        QueueConstructor myQueueConstructor = new QueueConstructor(4);
        myQueueConstructor.getFirst();
        myQueueConstructor.getLast();
        myQueueConstructor.getLength();
        myQueueConstructor.printQueue();
        System.out.println();

        QueueOperations myQueue = new QueueOperations(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue();
        System.out.println();

        myQueue.dequque();
        myQueue.dequque();
        myQueue.dequque();
        myQueue.dequque();
        myQueue.printQueue();
        System.out.println();
    }
}
