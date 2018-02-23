package shuwei.study.coursera.algorithm.third;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 上午10:25:45
 * 类说明
 */
public class MergeSort {
    
    public static <T> void sort(Comparable<T>[] arrays) {
        Comparable<T>[] res = mergeSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = res[i];
        }
    }
    
    public static <T> Comparable<T>[] mergeSort(Comparable<T>[] arrays, int start, int end) {
        if (start == end) {
            Comparable<T>[] r = new Comparable[1];
            r[0] = arrays[start];
            return r;
        }
        int middle = start + (end - start) / 2;
        Comparable<T>[] pre = mergeSort(arrays, start, middle);
        Comparable<T>[] aft = mergeSort(arrays, middle + 1, end);
        return sort(pre, aft);
    }
    
    public static <T> Comparable<T>[] sort(Comparable<T>[] sortedArr1, Comparable<T>[] sortedArr2) {
        int length1 = sortedArr1.length;
        int length2 = sortedArr2.length;
        Comparable<T>[] result = new Comparable[length1 + length2];
        int resultIndex = 0;
        for (int i = 0, j = 0; i < length1 || j < length2;) {
            if (i >= length1) {
                result[resultIndex++] = sortedArr2[j++];
                continue;
            }
            if (j >= length2) {
                result[resultIndex++] = sortedArr1[i++];
                continue;
            } else if (SortUtil.less(sortedArr1[i], sortedArr2[j])) {
                result[resultIndex++] = sortedArr1[i++];
            } else {
                result[resultIndex++] = sortedArr2[j++];
            }
        }
        return result;
    }
}
