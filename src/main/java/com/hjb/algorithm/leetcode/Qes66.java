package com.hjb.algorithm.leetcode;

import java.util.Arrays;

/**
 * ClassName: Qes66
 * Description:
 * Created by haojingbin on 2021/3/3 9:39
 *
 * @author haojingbin
 */
public class Qes66 {

    public static int[] plusOne1(int[] digits) {
        int length = digits.length;
        int[] result = new int[length + 1];
        int tmp = 1;
        for (int i = length - 1; i >= 0; i--) {
            int plusOne = digits[i] + tmp;
            result[i + 1] = plusOne % 10;
            tmp = plusOne / 10;
        }
        if (tmp > 0) {
            result[0] = 1;
            return result;
        }
        return Arrays.copyOfRange(result, 1, length + 1);
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i]++) % 10;
            if (digits[i] > 0) {
                return digits;
            }
        }
        digits = new int[digits.length];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] test = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne1(test)));
    }
}
