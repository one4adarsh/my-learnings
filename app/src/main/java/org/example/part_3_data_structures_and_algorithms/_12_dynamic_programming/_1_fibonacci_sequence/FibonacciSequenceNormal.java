package org.example.part_3_data_structures_and_algorithms._12_dynamic_programming._1_fibonacci_sequence;

public class FibonacciSequenceNormal {

    public static int fibNormalFunctionCount = 0;

    public static int fibNormal(int n) {
        fibNormalFunctionCount++;
        if (n == 0 || n == 1) {
            return n;
        }
        return fibNormal(n - 1) + fibNormal(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci of 40 is: " + fibNormal(40));
        System.out.println("Total function calls: " + fibNormalFunctionCount);
    }
}
