package com.hjb.algorithm.leetcode;

import java.util.Arrays;

/**
 * ClassName: Interview17P19
 * Description:
 * Created by haojingbin on 2021/2/22 14:49
 *
 * @author haojingbin
 */
public class Interview17P19 {

    public static int[] missingTwo1(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumTow = (n * (n + 1)) / 2 - sum;
        int towMid = sumTow / 2;
        sum = 0;
        for (int num : nums) {
            if (num <= towMid) {
                sum += num;
            }
        }
        int one = (towMid * (towMid + 1)) / 2 - sum;
        return new int[]{one, sumTow - one};
    }

    public static int[] missingTwo2(int[] nums) {
        int n = nums.length + 2;
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        for (int i = 1; i <= n; i++) {
            res ^= i;
        }
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((div & i) != 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};
    }

    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.toString(missingTwo1(test1)));
        System.out.println(Arrays.toString(missingTwo2(test1)));
        int[] test2 = new int[]{1, 2, 1, 2, 6, 6, 9, 13};
        System.out.println(Arrays.toString(singleNumbers(test2)));
        int[] test3 = new int[]{1, 2, 3, 5, 6, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(singleNumbers(test3)));

    }
}
