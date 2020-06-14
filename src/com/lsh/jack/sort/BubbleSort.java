package com.lsh.jack.sort;

import com.lsh.jack.utils.SortUtils;

import java.util.Objects;

/**
 *
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        Objects.requireNonNull(arr);

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            // 跳过剩余的循环。
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] ints = SortUtils.generateArray(20);
        SortUtils.print(ints, item -> bubbleSort(ints));
    }
}
