package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._01_overloading_methods;

class Overload {
    void test() {
        System.out.println("No Parameters");
    }

    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    void test(double a) {
        System.out.println("a: " + a);
    }
}

public class OverloadDemo {
    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.test();
        overload.test(22, 33);
        overload.test(88); // automatic type conversion
        overload.test(22.0);
    }
}

