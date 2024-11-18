package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._02_overloading_constructors;

class Box {
    double height;
    double width;
    double depth;

    // constructor when no dimensions are specified
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // constructor when 1 dimension is mentioned
    Box(double a) {
        height = width = depth = a;
    }

    // constructor when all dimensions are specified
    Box(double h, double w, double d) {
        width = w;
        height = h;
        depth = d;
    }

    void volume() {
        if (height < 0 || width < 0 || depth < 0) {
            System.out.println("invalid dimensions");
        } else {
            System.out.println("volume is " + height * width * depth);
        }
    }
}

public class OverloadConstructorDemo {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.volume();

        Box box2 = new Box(22);
        box2.volume();

        Box box3 = new Box(11, 11, 11);
        box3.volume();
    }
}
