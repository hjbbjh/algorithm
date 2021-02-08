package com.hjb.algorithm.leetcode;

/**
 * ClassName: Qes978
 * Description:
 * Created by haojingbin on 2021/2/8 16:32
 *
 * @author haojingbin
 */
public class Qes978 {

    public static int maxTurbulenceSizeByWindow(int[] arr) {
        int left = 0;
        int right = 0;
        int max = 0;
        if (arr.length == 1) {
            return 1;
        }
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[right] == arr[right + 1]) {
                    left++;
                }
                right++;
            } else {
                if ((arr[right - 1] > arr[right] && arr[right] < arr[right + 1])
                        || (arr[right - 1] < arr[right] && arr[right] > arr[right + 1])) {
                    right++;
                } else {
                    left = right;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static int maxTurbulenceSizeByDongTaiOn(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            //此处注意，需要默认为1
            dp[i][0] = dp[i][1] = 1;
            if (arr[i - 1] > arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] < arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }

    public static int maxTurbulenceSizeByDongTaiO1(int[] arr) {
        int dp0 = 1;
        int dp1 = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            max = Math.max(max, dp0);
            max = Math.max(max, dp1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSizeByWindow(arr1));
        System.out.println(maxTurbulenceSizeByDongTaiOn(arr1));
        System.out.println(maxTurbulenceSizeByDongTaiO1(arr1));
        int[] arr2 = new int[]{4, 8, 12, 16};
        System.out.println(maxTurbulenceSizeByWindow(arr2));
        System.out.println(maxTurbulenceSizeByDongTaiOn(arr2));
        System.out.println(maxTurbulenceSizeByDongTaiO1(arr2));
        int[] arr3 = new int[]{100};
        System.out.println(maxTurbulenceSizeByWindow(arr3));
        System.out.println(maxTurbulenceSizeByDongTaiOn(arr3));
        System.out.println(maxTurbulenceSizeByDongTaiO1(arr3));
    }
}
