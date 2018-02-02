package shuwei.study.algorithm.c1s4;

import java.util.Arrays;

/**
 * @author shuwei
 * @version 创建时间：2018年1月11日 上午9:16:32
 * p119
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(Arrays.binarySearch(a, -a[i]) > i) {
                cnt++;
            }
        }
        return cnt;
    }
}
