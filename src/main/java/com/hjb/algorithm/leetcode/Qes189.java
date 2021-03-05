package com.hjb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Optional;

/**
 * ClassName: Qes189
 * Description:
 * Created by haojingbin on 2021/3/1 11:02
 *
 * @author haojingbin
 */
public class Qes189 {

    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || length < 2) {
            return;
        }
        if (k > length) {
            k = k - length;
        }
        int[] tmp = new int[length];
        for (int i = 0; i < length; i++) {
            tmp[i] = nums[i];
        }
        int i = 0;
        for (int j = length - k; j < length; j++) {
            nums[i++] = tmp[j];
        }
        for (int j = 0; j < length - k; j++) {
            nums[i++] = tmp[j];
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, length);
    }

    public static void rotate3(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int count = gcd(length, k);
        for (int start = 0; start < count; start++) {
            int curent = start;
            int prev = nums[start];
            do {
                int next = (curent + k) % length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curent = next;
            } while (start != curent);
        }
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void rotate4(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start != end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(test1, 3);
        System.out.println(Arrays.toString(test1));
        test1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(test1, 3);
        System.out.println(Arrays.toString(test1));
        int[] test2 = new int[]{-1, -100, 3, 99};
        rotate1(test2, 2);
        System.out.println(Arrays.toString(test2));
        test2 = new int[]{-1, -100, 3, 99};
        rotate2(test2, 2);
        System.out.println(Arrays.toString(test2));
    }

}
