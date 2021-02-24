package com.lsh.jack.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortUtils {
    static int i = 5;
    static {
        i += 10;
    }


    static {
        i /= 3;
    }

    public static void main(String[] args) {
//        System.out.println(i);

        System.out.println(System.currentTimeMillis());

    }

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

    /**
     * 二分法查找
     * @param arr
     * @param val
     * @return
     */
    public static int binarySearch(int[] arr, int val) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid =  start + ((end - start) >> 1);
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void print(int[] arr, Consumer consumer) {
        int[] ints = new int[arr.length];
        System.arraycopy(arr, 0, ints, 0, arr.length);
        System.out.println("排序前的数据:" + Arrays.toString(arr));
        consumer.accept(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
        Arrays.sort(ints);
//        System.out.println("jdk排序后的数组:" + Arrays.toString(ints));
        System.out.println("排序是否正确:   " + Arrays.equals(arr, ints));
    }
}
