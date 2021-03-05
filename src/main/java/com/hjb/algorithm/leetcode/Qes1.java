package com.hjb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: Qes1
 * Description:
 * Created by haojingbin on 2021/3/3 11:39
 *
 * @author haojingbin
 */
public class Qes1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value1 = map.get(target - nums[i]);
            if (value1 != null) {
                return new int[]{value1, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(test, 9)));
    }
}
