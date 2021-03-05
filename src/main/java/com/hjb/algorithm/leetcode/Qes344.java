package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes344
 * Description:
 * Created by haojingbin on 2021/3/5 10:07
 *
 * @author haojingbin
 */
public class Qes344 {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

    }
}
