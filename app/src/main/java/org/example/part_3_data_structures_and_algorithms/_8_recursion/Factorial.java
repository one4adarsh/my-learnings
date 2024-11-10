package org.example.part_3_data_structures_and_algorithms._8_recursion;

public class Factorial {
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5 is " + factorial(5));
    }
}
