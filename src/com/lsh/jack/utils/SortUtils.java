package com.lsh.jack.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortUtils {

    private SortUtils() {
    }

    public static int[] generateArray(int length) {
        if (length < 0) {
            throw  new IllegalArgumentException("length must be greater than zero ");
        }
        int[] ints = new int[length];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10 * length);
        }
        return ints;
    }


    public static void print(int[] arr, Consumer consumer) {
        int[] ints = new int[arr.length];
        System.arraycopy(arr, 0, ints, 0, arr.length);
        System.out.println("排序前的数据:" + Arrays.toString(arr));
        consumer.accept(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
        Arrays.sort(ints);
        System.out.println("jdk排序后的数组:" + Arrays.toString(ints));
        System.out.println("排序是否正确:   " + Arrays.equals(arr, ints));
    }
}
