package shuwei.study.coursera.algorithm.third;

import edu.princeton.cs.algs4.StdRandom;
import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月5日 下午3:11:11
 * 类说明
 */
public class QuickSort {
    public static <T> void sort(Comparable<T>[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int k = partition(a, lo, hi);
        sort(a, lo, k - 1);
        sort(a, k + 1, hi);
    }
    
    private static <T> int partition(Comparable<T>[] a, int lo, int hi) {
        Comparable<T> key = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (SortUtil.less(key, a[--j])) {
                if (j == lo) {
                   break; 
                }
            }
            while (SortUtil.less(a[++i], key)) {
                if (i >= hi) {
                    break;
                }
            }
            if (i >= j ) {
                break;
            }
            SortUtil.swap(a, i, j);
        }
        SortUtil.swap(a, lo, j);
        return j;
    }
}
