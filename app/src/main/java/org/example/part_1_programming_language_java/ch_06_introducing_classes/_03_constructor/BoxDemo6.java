package org.example.part_1_programming_language_java.ch_06_introducing_classes._03_constructor;

public class BoxDemo6 {
    public static void main(String[] args) {
        Box myBox = new Box();
        System.out.println("default - The Volume is " + myBox.volume());

        Box myBox2 = new Box(12, 13, 14);
        System.out.println("parameterized - The volume is " + myBox2.volume());
    }
}
