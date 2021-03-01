package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes26
 * Description:
 * Created by haojingbin on 2021/3/1 9:22
 *
 * @author haojingbin
 */
public class Qes26 {

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                continue;
            }
            nums[++j] = nums[i];
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 1, 2};
        System.out.println(removeDuplicates1(test));
        int[] test1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(test1));
    }
}
