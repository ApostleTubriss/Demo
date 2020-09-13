package com.lasam.demo.sometests;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author liuhao
 * @date 2020/8/30 02:08
 */
public class StringTest {

    public static void main(String[] args) {
        //https://fcww27.com/get_file/1/e8d8a21b5d172b0b889d8bb325b0d74d92da775aee/52000/52227/52227.mp4/?download=true&download_filename=tp246.mp4
        System.out.println(hexStringToString("09a4e7dd8ab4b6ecffce8d6e8a07dfce"));
    }

    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "gbk");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
}
