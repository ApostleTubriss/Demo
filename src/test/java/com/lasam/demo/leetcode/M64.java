package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/6/2 23:24
 */
public class M64 {

    /**
     * 递归 || 短路 右边条件永真
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }


}
