package com.lasam.demo.leetcode;

public class P11 {

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public static void main(String[] args) {
        P11 p = new P11();
        int[] t = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(p.maxArea(t));
    }

    /**
     * 思路
     * 每一条边向左右伸长至最长(当前边作为最高点)，遍历一次，找到最大值
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int idx = 0; idx < height.length; idx++) {
            int h = height[idx];
            int maxV = getMaxV(idx, height);
            int value = maxV * h;
            max = Math.max(max, value);
        }

        return max;
    }

    /**
     * 一条边向左右能延长的最大长度
     */
    private int getMaxV(int i, int[] height) {

        int v = 0;
        int h = height[i];

        //左找到最远的比自己高的
        for (int idx = 0; idx < i; idx++) {
            if (height[idx] >= h) {
                v += i - idx;
                break;
            }
        }

        //右
        for (int idx = height.length - 1; idx > i; idx--) {
            if (height[idx] >= h) {
                v += idx - i;
                break;
            }
        }

        return v;
    }
}
