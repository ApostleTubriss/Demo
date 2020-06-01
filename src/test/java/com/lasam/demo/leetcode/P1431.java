package com.lasam.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1431 {

    public static void main(String[] args) {
        int[] t = new int[]{2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(t, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        //第一遍找到max
        int max = 0;
        for (int i : candies) {
            max = Math.max(i, max);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i : candies) {
            result.add((max - i) <= extraCandies);
        }

        return result;
    }
}
