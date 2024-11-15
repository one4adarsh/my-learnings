package org.example.part_3_data_structures_and_algorithms._1_linked_list;

public class LLOperations extends LLConstructor {
    LLOperations(int value) {
        super(value);
    }

    public void append(int value) {
        System.out.println("Append: " + value);
        NodeLL newNode = new NodeLL(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void removeLast() {
        if (length == 0) {
            System.out.println("Empty Linked List");
        } else if (head == tail) {
            System.out.println("Removed Last: " + head.value);
            head = null;
            tail = null;
            length = 0;
        } else {
            System.out.println("Removed Last: " + tail.value);
            NodeLL temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            length--;
        }
    }

    public void prepend(int value) {
        System.out.println("Prepend: " + value);
        NodeLL newNode = new NodeLL(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if (length == 0) {
            System.out.println("Empty Linked List");
        } else if (head == tail) {
            System.out.println("Removed First: " + head.value);
            head = null;
            tail = null;
            length = 0;
        } else {
            System.out.println("Removed First: " + head.value);
            head = head.next;
            length--;
        }
    }

    public void reverse() {
        System.out.println("Initially: ");
        printList();
        // swap head and tail
        NodeLL temp = head;
        head = tail;
        tail = temp;
        // define after and before
        NodeLL before = null;
        NodeLL after;
        // reverse
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        System.out.println("Finally: ");
        printList();
    }

    public NodeLL get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }
        NodeLL temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println("Current value (at index " + index + "): " + temp.value);
        return temp;
    }

    public boolean set(int index, int value) {
        NodeLL temp = get(index);
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
        NodeLL newNode = new NodeLL(value);
        NodeLL before = get(index - 1);
        newNode.next = before.next;
        before.next = newNode;
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
        NodeLL before = get(index-1);
        NodeLL temp = before.next;
        before.next = temp.next;
        temp.next = null;
        length--;
        System.out.println("Remove value (at index " + index + ") successful");
    }
}
