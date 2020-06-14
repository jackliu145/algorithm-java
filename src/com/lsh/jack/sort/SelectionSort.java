package com.lsh.jack.sort;

import com.lsh.jack.utils.SortUtils;

import java.util.Objects;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        Objects.requireNonNull(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = SortUtils.generateArray(20);
        SortUtils.print(ints, item -> selectionSort(ints));
    }
}
