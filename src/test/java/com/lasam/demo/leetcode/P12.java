package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/6/2 00:15
 */
public class P12 {

    public static void main(String[] args) {
        String t = new P12().intToRoman(78);
        System.out.println(t);
    }

    String[] one = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] ten = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    String[] hun = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};
    String[] thu = new String[]{"M", "MM", "MMM"};


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        sb.append(intToRoman(num / 1000, thu));
        sb.append(intToRoman((num / 100 % 10), hun));
        sb.append(intToRoman((num / 10 % 10), ten));
        sb.append(intToRoman(num % 10, one));

        return sb.toString();
    }

    public String intToRoman(int time, String[] jin) {
        if (time == 0) {
            return "";
        }
        return jin[time - 1];
    }
}
