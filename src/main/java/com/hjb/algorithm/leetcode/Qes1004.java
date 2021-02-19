package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes1004
 * Description:
 * Created by haojingbin on 2021/2/19 9:51
 *
 * @author haojingbin
 */
public class Qes1004 {

    public static int longestOnes2(int[] A, int K) {
        int lsum = 0;
        int rsum = 0;
        int left = 0;
        int result = 0;
        for (int right = 0; right < A.length; right++) {
            rsum += 1 - A[right];
            while (lsum < rsum - K) {
                lsum += 1 - A[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static int longestOnes1(int[] A, int K) {
        int n = A.length;
        int[] P = new int[n + 1];
        P[0] = 0;
        for (int i = 1; i <= n; i++) {
            P[i] = P[i - 1] + (1 - A[i - 1]);
        }
        int result = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(P, P[right + 1] - K);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static int binarySearch(int[] P, int target) {
        int low = 0;
        int high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes1(test, 2));
        System.out.println(longestOnes2(test, 2));
        int[] test1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes1(test1, 3));
        System.out.println(longestOnes2(test1, 3));
    }
}
