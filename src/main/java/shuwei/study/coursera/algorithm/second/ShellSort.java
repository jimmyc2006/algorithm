package shuwei.study.coursera.algorithm.second;

import java.util.Arrays;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月2日 上午11:10:46 类说明
 */
public class ShellSort {
    
    public static void main(String[] args) {
        Integer[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        sort(a);
        System.out.println(Arrays.deepToString(a));
        /*
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        */
    }
    
    public static <T> void sort(Comparable<T>[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h) {
                    SortUtil.swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
