package shuwei.study.coursera.algorithm.third;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 上午11:33:07
 * 类说明
 */
public class Merge {
    
    public static void sortBU(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
    
    public static void sort(Comparable[] a) {
        Comparable[] copy = new Comparable[a.length];
        sort(a, copy, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert SortUtil.isSorted(a, lo, mid);
        assert SortUtil.isSorted(a, mid + 1, hi);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortUtil.less (aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
    
    public static void sortedBU(Comparable[] a) {
        int N = a.length;
        Comparable[] copy = new Comparable[N];
        for (int size = 1; size < N; size *= 2) {
            for (int lo = 0; lo < N;lo += 2 * size) {
                int mid = Math.min(lo + size - 1, N - 1);
                int hi = Math.min(mid + size, N - 1);
                merge(a, copy, lo, mid, hi);
            }
        }
    }
}
