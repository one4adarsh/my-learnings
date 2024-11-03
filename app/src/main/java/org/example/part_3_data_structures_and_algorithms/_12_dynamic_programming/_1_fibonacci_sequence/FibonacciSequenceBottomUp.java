package org.example.part_3_data_structures_and_algorithms._12_dynamic_programming._1_fibonacci_sequence;

public class FibonacciSequenceBottomUp {
    public static int fibBottomUpFunctionCount = 0;

    public static int fibBottomUp(int n) {
        int[] fibBottomUpList = new int[n + 1]; // space can be optimised too, just save last 2 values
        fibBottomUpList[0] = 0;
        fibBottomUpList[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibBottomUpFunctionCount++;
            fibBottomUpList[i] = fibBottomUpList[i - 1] + fibBottomUpList[i - 2];
        }
        return fibBottomUpList[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci of 40 is: " + fibBottomUp(40));
        System.out.println("Total function calls = (2n-1), i.e: " + fibBottomUpFunctionCount);
    }
}
