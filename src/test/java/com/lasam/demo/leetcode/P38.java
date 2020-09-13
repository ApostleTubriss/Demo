package com.lasam.demo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuhao
 * @date 2020/9/13 14:14
 */
public class P38 {

    public static void main(String[] args) {

    }

    public String countAndSay(int n) {

        String[] result = new String[30];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = "1";
                continue;
            }
            result[i] = compressStr(result[i - 1]);
        }

        return result[n - 1];
    }

    private String compressStr(String s) {
        StringBuilder sb = new StringBuilder();

        Character now = null;
        Integer times = 0;
        for (char c : s.toCharArray()) {
            if (now == null) {
                now = c;
                times = 1;
                continue;
            }
            if (now == c) {
                times++;
                continue;
            }

            sb.append(times).append(now);
            now = c;
            times = 1;
        }

        sb.append(times).append(now);

        return sb.toString();
    }
}
