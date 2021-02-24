package com.lsh.jack.sort;

import com.lsh.jack.utils.SortUtils;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] ints = SortUtils.generateArray(20);
        SortUtils.print(ints, item ->quickSort(ints, 0, ints.length-1));
//        int val = (int)(Math.random() * 20);
//        int val = ints[new Random().nextInt(ints.length)];
        int val = ints[8];
        System.out.println("val = " + val);
        System.out.println(val + " 索引位置" + SortUtils.binarySearch(ints, val));
    }

    private static void quickSort(int[] ints, int start, int end) {
        if (start < end) {
            int partition = partition(ints, start, end);
            quickSort(ints, start, partition-1);
            quickSort(ints, partition+1, end);
        }
    }

    private static int partition(int[] ints, int start, int end) {
        int pivot = ints[end];
        int counter = start;
        for (int i = start; i < end; i++) {
            if (pivot > ints[i]) {
                int temp = ints[i];
                ints[i] = ints[counter];
                ints[counter++] = temp;
            }
        }
        int temp = ints[counter];
        ints[counter] = pivot;
        ints[end] = temp;

        return counter;
    }
}
