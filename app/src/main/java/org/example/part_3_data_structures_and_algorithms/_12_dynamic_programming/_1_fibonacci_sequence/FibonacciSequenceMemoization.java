package org.example.part_3_data_structures_and_algorithms._12_dynamic_programming._1_fibonacci_sequence;

public class FibonacciSequenceMemoization {

    public static int fibMemoizationFunctionCount = 0;
    public static Integer[] memo = new Integer[100];

    public static int fibMemoization(int n) {
        fibMemoizationFunctionCount++;

        if (memo[n] != null) {
            return memo[n];
        }

        if(n == 0 || n == 1) {
            return n;
        }

        memo[n] = fibMemoization(n-1) + fibMemoization(n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci of 40 is: " + fibMemoization(40));
        System.out.println("Total function calls = (2n-1), i.e: " + fibMemoizationFunctionCount);
    }
}
