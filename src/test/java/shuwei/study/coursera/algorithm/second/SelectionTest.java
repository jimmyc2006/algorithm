package shuwei.study.coursera.algorithm.second;



import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.util.SortUtil;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 下午1:59:38
 * 类说明
 */
public class SelectionTest {
    @Test
    public void testSort() {
        for (int i = 1; i < 100; i++) {
            Integer[] data = SortUtil.generate(i);
            Selection.sort(data);
            Assert.assertTrue(SortUtil.isSorted(data));
        }
    }
    
    public static void main(String[] args) {
        // 倍率测试
        long preComsumeTime = 0;
        for (int i = 64; true; i *= 2) {
            Integer[] data = SortUtil.generate(i);
            long start = System.currentTimeMillis();
            Selection.sort(data);
            long end = System.currentTimeMillis();
            if (preComsumeTime > 0) {
                System.out.println(i + " 倍率:" + ((double)(end - start) / preComsumeTime));
            }
            preComsumeTime = end - start;
        }
    }
}
