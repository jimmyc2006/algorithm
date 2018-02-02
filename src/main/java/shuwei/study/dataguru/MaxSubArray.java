package shuwei.study.dataguru;

/**
 * @author shuwei
 * @version 创建时间：2018年1月10日 下午4:54:03
 * 
 */
public class MaxSubArray {

    public static int maxSub(int[] arr, int start, int end) {
        if (end == start) {
            return arr[start];
        }
        int middle = start + (end - start) / 2;
        int maxLeft = maxSub(arr, start, middle);
        int maxRight = maxSub(arr, middle + 1, end);
        int maxMiddle = maxMiddle(arr, start, middle, end);
        if (maxLeft > maxRight) {
            return maxLeft > maxMiddle ? maxLeft : maxMiddle;
        } else {
            return maxRight > maxMiddle ? maxRight : maxMiddle;
        }
    }

    static int maxMiddle(int[] arr, int start, int middle, int end) {
        return maxSumDecrease(arr, middle, start) + maxSumIncrease(arr, middle + 1, end);
    }

    static int maxSumIncrease(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int max = arr[start];
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
    
    static int maxSumDecrease(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int max = arr[start];
        int sum = 0;
        for (int i = start; i >= end; i--) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
