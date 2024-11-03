package org.example.part_3_data_structures_and_algorithms._12_dynamic_programming._1_fibonacci_sequence;

public class CompareFib {
    public static void main(String[] args) {
        System.out.println("Fibonacci of 40: " + FibonacciSequenceNormal.fibNormal(40));
        System.out.println("Total function calls: " + FibonacciSequenceNormal.fibNormalFunctionCount + "\n");

        System.out.println("Fibonacci of 40: " + FibonacciSequenceMemoization.fibMemoization(40));
        System.out.println("Total function calls: " + FibonacciSequenceMemoization.fibMemoizationFunctionCount + "\n");

        System.out.println("Fibonacci of 40: " + FibonacciSequenceBottomUp.fibBottomUp(40));
        System.out.println("Total function calls: " + FibonacciSequenceBottomUp.fibBottomUpFunctionCount + "\n");
    }
}
