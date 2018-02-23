package shuwei.study.coursera.algorithm.third;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 上午10:55:15
 * 类说明
 */
public class MergeTest {
    
    @Test
    public void testSort() {
        Integer[] array = {3, 1, 7, 2, 5, 8};
        Merge.sort(array);
        Assert.assertTrue(SortUtil.isSorted(array));
    }
    
    @Test
    public void testSortBU() {
        for (int i = 1; i < 30; i++) {
            Integer[] data = SortUtil.generate(i);
            Merge.sortBU(data);
            Assert.assertTrue(SortUtil.isSorted(data));
        }
    }
    
    @Test
    public void testSortedBU() {
        for (int i = 1; i < 30; i++) {
            Integer[] data = SortUtil.generate(i);
            Merge.sortedBU(data);
            if (!SortUtil.isSorted(data)) {
                System.out.println(Arrays.deepToString(data));
            }
            Assert.assertTrue(SortUtil.isSorted(data));
        }
    }
    
    public static void doubleRatioTest() {
        long init = System.currentTimeMillis();
        // 倍率测试
        long preComsumeTime = 0;
        for (int i = 64; true; i *= 2) {
            Integer[] data = SortUtil.generate(i);
            long start = System.currentTimeMillis();
            Merge.sort(data);
            long end = System.currentTimeMillis();
            if (preComsumeTime > 0) {
                System.out.println(i + " 倍率:" + ((double)(end - start) / preComsumeTime));
            }
            preComsumeTime = end - start;
            System.out.println("总耗时:" + (System.currentTimeMillis() - init));
        }
    }
    
    public static void averageTest(int length, int times) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            long s = System.currentTimeMillis();
            Integer[] data = SortUtil.generate(length);
            Merge.sort(data);
            System.out.println("第" + i + "次，耗时:" + (System.currentTimeMillis() - s));
        }
        System.out.println("长度" + length + ", " + times + "次，平均耗时" + ((System.currentTimeMillis() - start) / times));
    }
    
    public static void main(String[] args) {
        averageTest(4194304, 20);
    }
}
