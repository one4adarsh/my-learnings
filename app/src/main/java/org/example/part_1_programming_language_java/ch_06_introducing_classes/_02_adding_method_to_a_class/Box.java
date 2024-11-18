package org.example.part_1_programming_language_java.ch_06_introducing_classes._02_adding_method_to_a_class;

public class Box {
    double height;
    double width;
    double depth;

//    void volume() {
//        System.out.println("Volume is ");
//        System.out.println(width * height * depth);
//    }

    double volume() {
        return width * height * depth;
    }
}
