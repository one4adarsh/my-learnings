package org.example.part_1_programming_language_java.ch_06_introducing_classes._03_constructor;

public class Box {
    double height;
    double width;
    double depth;

    // default constructor
    Box() {
        height = 10;
        width = 10;
        depth = 10;
    }

    // parameterized constructor
    Box(double h, double w, double d) {
        height = h;
        width = w;
        depth = d;
    }

    double volume() {
        return height * width * depth;
    }
}
