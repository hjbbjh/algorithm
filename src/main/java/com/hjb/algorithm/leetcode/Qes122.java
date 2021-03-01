package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes122
 * Description:
 * Created by haojingbin on 2021/3/1 9:53
 *
 * @author haojingbin
 */
public class Qes122 {

    public static int maxProfit1(int[] prices) {
        int sum = 0;
        int j = 0;
        int length = prices.length;
        if (length < 2) {
            return sum;
        }
        for (int i = 0; i < length - 1; i++) {
            if (prices[i] >= prices[i + 1]) {
                sum += prices[i] - prices[j];
                j = i + 1;
            }
        }
        if (prices[length - 2] < prices[length - 1]) {
            sum += prices[length - 1] - prices[j];
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] test1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(test1));
        System.out.println(maxProfit2(test1));
        int[] test2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit1(test2));
        System.out.println(maxProfit2(test2));
        int[] test3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit1(test3));
        System.out.println(maxProfit2(test3));
    }
}
