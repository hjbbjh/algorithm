package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes766
 * Description:
 * Created by haojingbin on 2021/2/22 14:07
 *
 * @author haojingbin
 */
public class Qes766 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
        int[][] matri1 = {{1, 2}, {2, 2}};
        System.out.println(isToeplitzMatrix(matri1));
    }
}
