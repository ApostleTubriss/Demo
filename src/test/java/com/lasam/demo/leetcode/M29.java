package com.lasam.demo.leetcode;

import java.util.Arrays;

/**
 * @author liuhao
 * @date 2020/6/5 00:06
 */
public class M29 {

    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1};

        System.out.println(Arrays.toString(new M29().spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        int h = matrix.length;
        if (h == 0) {
            return new int[0];
        }
        int v = matrix[0].length;
        if (v == 0) {
            return new int[0];
        }
        int[] result = new int[v * h];
        boolean[][] used = new boolean[h][v];
        //1 right 2 down 3 left 4 up
        int vet = 1;
        int x = 0;
        int y = 0;
        int index = 0;
        while (true) {
            if (vet == 1) {
                if (!used[x][y]) {
                    result[index] = matrix[x][y];
                    used[x][y] = true;
                    if (y + 1 >= v || used[x][y + 1]) {
                        vet = 2;
                        if (++x >= h) {
                            break;
                        }
                    } else {
                        y++;
                    }
                    index++;
                    continue;
                } else {
                    break;
                }
            }
            if (vet == 2) {
                if (!used[x][y]) {
                    result[index] = matrix[x][y];
                    used[x][y] = true;
                    if (x + 1 >= h || used[x + 1][y]) {
                        vet = 3;
                        if (--y < 0) {
                            break;
                        }
                    } else {
                        x++;
                    }
                    index++;
                    continue;
                } else {
                    break;
                }
            }
            if (vet == 3) {
                if (!used[x][y]) {
                    result[index] = matrix[x][y];
                    used[x][y] = true;
                    if (y - 1 < 0 || used[x][y - 1]) {
                        vet = 4;
                        if (--x < 0) {
                            break;
                        }
                    } else {
                        y--;
                    }
                    index++;
                    continue;
                } else {
                    break;
                }
            }
            if (vet == 4) {
                if (!used[x][y]) {
                    result[index] = matrix[x][y];
                    used[x][y] = true;
                    if (x - 1 < 0 || used[x - 1][y]) {
                        vet = 1;
                        if (++y > v) {
                            break;
                        }
                        ;
                    } else {
                        x--;
                    }
                    index++;
                    continue;
                } else {
                    break;
                }
            }

        }
        return result;
    }
}
