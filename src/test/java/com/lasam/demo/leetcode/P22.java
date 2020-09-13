package com.lasam.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuhao
 * @date 2020/7/26 10:32
 */
public class P22 {

    public static void main(String[] args) {
        new P22().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {

        List<String> allString = new ArrayList<>();
        build("(", 1, 0, n, allString);
        System.out.println(allString);

        return null;
    }

    private void build(String now, int l, int r, int n, List<String> result) {
        if (l == n && r == n) {
            if (valid(now)) {
                result.add(now);
            }
            return;
        }
        if (l < n) {
            build(now + "(", l + 1, r, n, result);
        }
        if (r < n) {
            build(now + ")", l, r + 1, n, result);
        }
    }

    private boolean valid(String now) {
        char[] charArr = now.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : charArr) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
}
