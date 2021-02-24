package com.lsh.jack.array;

public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbbdd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i+1;
            String subString = s.substring(start, end);
            while (end < s.length() && subString.indexOf(s.charAt(end)) == -1) {
                subString = s.substring(start, ++end);
            }
            max = Math.max(max, subString.length());
        }
        return max;
    }
}
