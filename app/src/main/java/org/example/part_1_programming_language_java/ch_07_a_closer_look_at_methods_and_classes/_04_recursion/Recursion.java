package org.example.part_1_programming_language_java.ch_07_a_closer_look_at_methods_and_classes._04_recursion;

class Factorial {
    int fact(int n) {
        int result;

        if (n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}

public class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println("Factorial 5 = " + f.fact(5));
    }
}
