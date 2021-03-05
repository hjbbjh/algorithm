package com.hjb.algorithm.leetcode;

import java.util.Arrays;

/**
 * ClassName: Qes283
 * Description:
 * Created by haojingbin on 2021/3/3 10:49
 *
 * @author haojingbin
 */
public class Qes283 {

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 0, 3, 12};
        moveZeroes(test);
        System.out.println(Arrays.toString(test));
    }

}
