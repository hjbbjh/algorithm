package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes7
 * Description:
 * Created by haojingbin on 2021/3/5 10:19
 *
 * @author haojingbin
 */
public class Qes7 {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pos = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pos > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pos < -8)) {
                return 0;
            }
            result = result * 10 + pos;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
