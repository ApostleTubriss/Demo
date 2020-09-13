package com.lasam.demo.leetcode;

import java.util.Arrays;

/**
 * @author liuhao
 * @date 2020/8/30 18:46
 */
public class P27 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 5, 2};
        System.out.println(new P27().removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (now != val) {
                if (i == nums.length - 1) {
                    return nums.length;
                }
                continue;
            }

            //now == val
            if (i == nums.length - 1) {
                return i;
            }

            boolean sw = false;
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];
                if (right == val) {
                    continue;
                }
                //can switch
                nums[i] = right;
                nums[j] = now;
                sw = true;
                break;
            }

            //no switch
            if (!sw) {
                return i;
            }
        }

        return -1;
    }
}
