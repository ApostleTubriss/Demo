package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/9/13 14:02
 */
public class P35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        //找到第一个大于等于target的
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (now >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
