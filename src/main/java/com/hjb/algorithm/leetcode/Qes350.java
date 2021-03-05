package com.hjb.algorithm.leetcode;

import java.time.Instant;
import java.util.*;

/**
 * ClassName: Qes350
 * Description:
 * Created by haojingbin on 2021/3/2 10:25
 *
 * @author haojingbin
 */
public class Qes350 {

    public static int[] intersects1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int j = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                result[j++] = i;
                if (--count > 0) {
                    map.put(i, count);
                } else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, j);
    }

    public static int[] intersects2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int cur1 = 0;
        int cur2 = 0;
        int[] result = new int[nums1.length];
        int j = 0;
        while (cur1 < nums1.length && cur2 < nums2.length) {
            if (nums1[cur1] == nums2[cur2]) {
                result[j++] = nums1[cur1];
                cur1++;
                cur2++;
            } else if (nums1[cur1] < nums2[cur2]) {
                cur1++;
            } else {
                cur2++;
            }
        }
        return Arrays.copyOfRange(result, 0, j);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2,};
        System.out.println(Arrays.toString(intersects1(nums1, nums2)));
        System.out.println(Arrays.toString(intersects2(nums1, nums2)));
    }

}
