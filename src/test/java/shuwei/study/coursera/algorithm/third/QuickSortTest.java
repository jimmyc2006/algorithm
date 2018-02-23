package shuwei.study.coursera.algorithm.third;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月5日 下午3:25:15
 * 类说明
 */
public class QuickSortTest {
    @Test
    public void testSort() {
        int times = 30;
        for (int i = 1; i < times; i++) {
            Integer[] data = SortUtil.generate(i);
            QuickSort.sort(data);
            Assert.assertTrue(SortUtil.isSorted(data));
        }
    }
    
    private static void boubleRatioTest() {
        long init = System.currentTimeMillis();
        // 倍率测试
        long preComsumeTime = 0;
        for (int i = 64; true; i *= 2) {
            Integer[] data = SortUtil.generate(i);
            long start = System.currentTimeMillis();
            QuickSort.sort(data);
            long end = System.currentTimeMillis();
            if (preComsumeTime > 0) {
                System.out.println(i + " 倍率:" + ((double)(end - start) / preComsumeTime));
            }
            preComsumeTime = end - start;
            System.out.println("总耗时:" + (System.currentTimeMillis() - init));
        }
    }
    
    private static void boubleRatioTestCompare() {
        int allQS = 0;
        int allQ = 0;
        // 倍率测试
        for (int i = 64; i <= 33554432; i *= 2) {
            Integer[] data = SortUtil.generate(i);
            Integer[] data2 = Arrays.copyOfRange(data, 0, data.length);
            long start = System.currentTimeMillis();
            QuickSort.sort(data);
            long duration = System.currentTimeMillis() - start;
            allQS += duration;
            System.out.println(i + ",QuickSort耗时:" + duration);
            start = System.currentTimeMillis();
            Quick.sort(data2);
            long duration2 = System.currentTimeMillis() - start;
            allQ += duration2;
            System.out.println(i + ",Quick耗时:" + (System.currentTimeMillis() - start));
        }
        System.out.println("allQS:" + allQS + ", allQ:" + allQ);
    }
    
    public static void averageTest(int length, int times) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            long s = System.currentTimeMillis();
            Integer[] data = SortUtil.generate(length);
            QuickSort.sort(data);
            System.out.println("第" + i + "次，耗时:" + (System.currentTimeMillis() - s));
        }
        System.out.println("长度" + length + ", " + times + "次，平均耗时" + ((System.currentTimeMillis() - start) / times));
    }
    
    public static void main(String[] args) {
        //averageTest(4194304, 20);
        boubleRatioTestCompare();
    }
}
