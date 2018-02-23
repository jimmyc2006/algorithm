package shuwei.study.coursera.algorithm.second;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 下午2:08:56
 * 插入排序
 */
public class Insertion {
    
    public static <T> void sort(Comparable<T>[] data) {
        int length = data.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtil.less(data[j], data[j - 1])) {
                    SortUtil.swap(data, j, j - 1);
                }
            }
        }
    }
}
