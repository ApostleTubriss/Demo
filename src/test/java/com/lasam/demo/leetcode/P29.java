package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/9/1 22:36
 */
public class P29 {

    public static void main(String[] args) {
        System.out.println(new P29().divide(2147483647, 2));
    }

    public int divide(int dividend, int divisor) {

        long a = Math.abs(Long.valueOf(dividend));
        long b = Math.abs(Long.valueOf(divisor));
        if (a < b || a == 0) {
            return 0;
        }

        boolean zheng = true;
        if (dividend > 0 && divisor < 0) {
            zheng = false;
        }
        if (dividend < 0 && divisor > 0) {
            zheng = false;
        }

        long left = a;
        long times = 0;
        while (left >= b) {
            times++;
            left -= b;
        }


        long result = zheng ? times : -times;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }
}
