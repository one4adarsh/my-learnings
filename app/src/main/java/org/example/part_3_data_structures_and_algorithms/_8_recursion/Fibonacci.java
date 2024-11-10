package org.example.part_3_data_structures_and_algorithms._8_recursion;

public class Fibonacci {
    private static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
