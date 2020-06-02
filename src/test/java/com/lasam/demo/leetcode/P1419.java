package com.lasam.demo.leetcode;

import java.util.Map;

/**
 * @author liuhao
 * @date 2020/6/2 23:43
 */
public class P1419 {

    /**
     * croak
     * 参考俄罗斯方块
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        //必须是5的倍数
        int len = croakOfFrogs.length();
        if (len % 5 != 0) {
            return -1;
        }

        //最大并发
        int[] con = new int[5];

        int atLeast = 0;
        for (char s : croakOfFrogs.toCharArray()) {
            if (s == 'c') {
                con[0] += 1;
                atLeast = Math.max(con[0], atLeast);
            }
            if (s == 'r') {
                if (con[0] == 0) {
                    return -1;
                }
                con[1] += 1;
            }
            if (s == 'o') {
                if (con[1] == 0) {
                    return -1;
                }
                con[2] += 1;
            }
            if (s == 'a') {
                if (con[2] == 0) {
                    return -1;
                }
                con[3] += 1;
            }
            if (s == 'k') {
                if (con[3] == 0) {
                    return -1;
                }
                con[0] -= 1;
                con[1] -= 1;
                con[2] -= 1;
                con[3] -= 1;
            }
        }
        return atLeast;
    }


    public static void main(String[] args) {

        System.out.println(new P1419().minNumberOfFrogs("croakcrook"));
    }
}
