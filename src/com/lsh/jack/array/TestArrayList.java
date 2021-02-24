package com.lsh.jack.array;

import java.util.PriorityQueue;

public class TestArrayList {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("jack");
//        list.add("sdfs");
//
//        for (String s : list) {
//            System.out.println(s);
//        }

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(1);
        integers.offer(2);
        integers.offer(-1);
        integers.offer(4);
        integers.offer(6);

        for (int i = 0; i < 20; i++) {
            integers.offer((int)(Math.random() * 100));
        }

        while (!integers.isEmpty()) {
            System.out.print(integers.poll() + ",");
        }

    }
}
