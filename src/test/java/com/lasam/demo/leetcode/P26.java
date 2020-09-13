package com.lasam.demo.leetcode;

import java.util.Arrays;

/**
 * @author liuhao
 * @date 2020/8/30 18:31
 */
public class P26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3, 4, 4, 5};
        System.out.println(new P26().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 1;

        Integer now = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                now = nums[0];
                continue;
            }
            if (nums[i] == now) {
                continue;
            }
            nums[len] = nums[i];
            now = nums[i];
            len++;
        }

        return len;
    }
}
