package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/5/29 23:36
 */
public class P198 {

    public static void main(String[] args) {
        int[] money = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(money));
    }

    /**
     * 动态规划
     */
    public static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        /*
        一间，肯定偷
        最大值为dp1=value(1)
        两间，偷或者不偷
        dp2=max(value(1),value(2))

        大于3时 偷 则是 dp[n-2]+value(3)
        不偷 则是 dp[n-1]
        通过大小比较得到最大值
         */
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //存储偷前N间房的最大值
        int[] total = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                total[0] = nums[0];
                continue;
            }
            if (i == 1) {
                total[1] = Math.max(nums[1], total[0]);
                continue;
            }

            int rob = total[i - 2] + nums[i];
            int notRob = total[i - 1];

            total[i] = Math.max(rob, notRob);
        }

        return total[total.length - 1];
    }
}
