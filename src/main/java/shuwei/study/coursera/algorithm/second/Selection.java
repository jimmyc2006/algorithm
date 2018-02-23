package shuwei.study.coursera.algorithm.second;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 下午1:55:20
 * 选择排序
 */
public class Selection {
    
    public static <T> void sort(Comparable<T>[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (SortUtil.less(data[j], data[i])) {
                    SortUtil.swap(data, i, j);
                }
            }
        }
    }
}
