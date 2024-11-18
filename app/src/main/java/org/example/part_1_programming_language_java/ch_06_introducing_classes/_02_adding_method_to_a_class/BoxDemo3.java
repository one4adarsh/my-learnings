package org.example.part_1_programming_language_java.ch_06_introducing_classes._02_adding_method_to_a_class;

public class BoxDemo3 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();

        myBox1.height = 10;
        myBox1.width = 10;
        myBox1.depth = 10;
//        myBox1.volume()
        System.out.println("The Volume is " + myBox1.volume());

        myBox2.height = 20;
        myBox2.width = 20;
        myBox2.depth = 20;
//        myBox2.volume()
        System.out.println("The Volume is " + myBox2.volume());
    }
}
