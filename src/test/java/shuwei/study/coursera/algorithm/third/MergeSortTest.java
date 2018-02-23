package shuwei.study.coursera.algorithm.third;

import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 上午10:55:15
 * 类说明
 */
public class MergeSortTest {
    
    @Test
    public void testSort() {
        Integer[] array = {3, 1, 7, 2, 5, 8};
        MergeSort.sort(array);
        Assert.assertTrue(SortUtil.isSorted(array));
    }
    
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        // 倍率测试
        long preComsumeTime = 0;
        for (int i = 64; true; i *= 2) {
            Integer[] data = SortUtil.generate(i);
            Integer[] data2 = new Integer[i];
            long start = System.currentTimeMillis();
            MergeSort.sort(data);
            long end = System.currentTimeMillis();
            if (preComsumeTime > 0) {
                System.out.println(i + " 倍率:" + ((double)(end - start) / preComsumeTime));
            }
            preComsumeTime = end - start;
            System.out.println("总耗时:" + (System.currentTimeMillis() - init));
        }
    }
}
