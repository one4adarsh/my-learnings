package org.example.part_3_data_structures_and_algorithms._11_sorting;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapindex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapindex++;
                swap(array, swapindex, i);
            }
        }
        swap(array, pivotIndex, swapindex);

        return swapindex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
