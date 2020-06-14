package com.lsh.jack.sort;

import com.lsh.jack.utils.SortUtils;

import java.util.Objects;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        Objects.requireNonNull(arr);
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            int temp = arr[i];
            while (k > 0 && temp < arr[k-1]) {
                arr[k] = arr[k-1];
                k--;
            }
            arr[k] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = SortUtils.generateArray(10);
        SortUtils.print(ints, item -> insertSort(ints));
    }
}
