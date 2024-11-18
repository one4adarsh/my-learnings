package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._03_overload_objects;

class Box {
    double height;
    double width;
    double depth;

    // constructor - takes an object as param
    Box(Box box) {
        height = box.height;
        width = box.width;
        depth = box.depth;
    }

    // constructor - no param
    Box() {
        height = width = depth = -1;
    }

    // constructor  - 1 param
    Box(double a) {
        height = width = depth = a;
    }

    // constructor - 3 param
    Box(double h, double w, double d) {
        height = h;
        width = w;
        depth = d;
    }

    // return object
    Box increaseDimensions(double a) {
        return new Box(height + a, width + a, depth + a);
    }

    double volume() {
        return height * width * depth;
    }

    boolean volumeEqual(Box box) {
        return box.volume() == this.volume();
    }
}

public class OverloadObjects {
    public static void main(String[] args) {
        Box box1 = new Box(2, 2, 2);
        Box box1copy = new Box(box1);
        System.out.println("box1 volume" + box1.volume());
        System.out.println("box1copy volume" + box1copy.volume());

        Box box2 = new Box(8, 1, 1);
        System.out.println("is box1 volume equals box2? " + box2.volumeEqual(box1));

        Box box1increase = box1.increaseDimensions(2);
        System.out.println("box1increase volume: " + box1increase.volume());
    }
}
