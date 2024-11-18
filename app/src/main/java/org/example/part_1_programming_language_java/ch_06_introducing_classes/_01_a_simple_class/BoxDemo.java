package org.example.part_1_programming_language_java.ch_06_introducing_classes._01_a_simple_class;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox = new Box();
        double vol;

        myBox.width = 10;
        myBox.height = 15;
        myBox.depth = 20;

        vol = myBox.width * myBox.height * myBox.depth;

        System.out.println("Volume is " + vol);
    }
}
