package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/8/30 18:16
 */
public class P557 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        String[] str = s.split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : str) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.insert(0, c);
            }
            result.append(sb).append(" ");
        }
        return result.toString().trim();
    }
}
