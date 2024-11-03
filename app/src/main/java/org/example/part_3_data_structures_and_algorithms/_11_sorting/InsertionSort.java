package org.example.part_3_data_structures_and_algorithms._11_sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
