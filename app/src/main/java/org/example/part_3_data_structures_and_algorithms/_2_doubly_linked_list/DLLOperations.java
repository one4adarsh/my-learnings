package org.example.part_3_data_structures_and_algorithms._2_doubly_linked_list;

public class DLLOperations extends DLLConstructor {

    DLLOperations(int value) {
        super(value);
    }

    public void append(int value) {
        System.out.println("Append: " + value);
        NodeDLL newNode = new NodeDLL(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void removeLast() {
        if (length == 0) {
            System.out.println("Empty Doubly Linked List");
        } else if (head == tail) {
            System.out.println("Removed Last: " + head.value);
            head = null;
            tail = null;
            length = 0;
        } else {
            System.out.println("Removed Last: " + tail.value);
            // Tech 1: Iterate
            /*
            NodeDLL temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail.prev = null;
            tail = temp;
            tail.next = null;
            length--;
             */

            // Tech 2: DLL can be traversed backward
            tail = tail.prev;
            tail.next = null;
            length--;
        }
    }

    public void prepend(int value) {
        System.out.println("Prepend: " + value);
        NodeDLL newNode = new NodeDLL(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if (length == 0) {
            System.out.println("Empty Doubly Linked List");
        } else if (head == tail) {
            System.out.println("Removed First: " + head.value);
            head = null;
            tail = null;
            length = 0;
        } else {
            System.out.println("Removed First: " + head.value);
            head = head.next;
            head.prev = null;
            length--;
        }
    }

    public NodeDLL get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }
        NodeDLL temp = head;
        if (index <= length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int j = length - 1; j > index; j--) {
                temp = temp.prev;
            }
        }
        System.out.println("Current value (at index " + index + "): " + temp.value);
        return temp;
    }

    public boolean set(int index, int value) {
        NodeDLL temp = get(index);
        if (temp != null) {
            temp.value = value;
            System.out.println("Updated value (at index " + index + " ): " + value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Invalid Index");
            return false;
        }
        if (index == 0) {
            System.out.print("Index = " + index + " - ");
            prepend(value);
            return true;
        }
        if (index == length) {
            System.out.print("Index = " + index + " - ");
            append(value);
            return true;
        }
        System.out.println("Index = " + index + " - ");
        NodeDLL newNode = new NodeDLL(value);
        NodeDLL before = get(index - 1);
        NodeDLL after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        System.out.println("Inserted value (at index " + index + " ): " + value);
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            System.out.print("Index = " + index + " - ");
            removeFirst();
            return;
        }
        if (index == length - 1) {
            System.out.print("Index = " + index + " - ");
            removeLast();
            return;
        }
        System.out.println("Index = " + index + " - ");
        NodeDLL temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        System.out.println("Remove value (at index " + index + ") successful");
    }
}
