package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes136
 * Description:
 * Created by haojingbin on 2021/3/2 10:21
 *
 * @author haojingbin
 */
public class Qes136 {

    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 2, 1};
        System.out.println(singleNumber1(test1));
        int[] test2 = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber1(test2));
    }

}
