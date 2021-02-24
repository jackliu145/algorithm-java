package com.lsh.jack.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * args -Xms1M -Xmx1M
 */
public class OomDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList();
//        int i = 0;
//        while (true) {
//            list.add("fdf" + Math.random() + i++);
//        }
//
        List<String> list = _generateParenthesis(0, 0, 3, "");
        System.out.println(list);

    }


    private static List<String> _generateParenthesis(int left, int right, int count, String s) {
        List<String> result = new ArrayList<>();
        // terminated
        if (left == count && right == count) {
            result.add(s);
//            System.out.println(s);
            return result;
        }
        // process current

        if (left < count) {
            result.addAll(_generateParenthesis(left + 1, right, count, s + "("));
        }
        // drill down
        if (right < left)
            result.addAll(_generateParenthesis(left, right + 1, count, s + ")"));

        // revert
        return result;
    }
}
