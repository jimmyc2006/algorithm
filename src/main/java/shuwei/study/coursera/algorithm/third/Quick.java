package shuwei.study.coursera.algorithm.third;

import shuwei.study.coursera.algorithm.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author shuwei
 * @version 创建时间：2018年2月5日 下午3:54:58
 * p182
 */
public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (SortUtil.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtil.swap(a, i, j);
        }
        SortUtil.swap(a, lo, j);
        return j;
    }
}