package shuwei.study.dataguru;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2018年1月10日 下午5:30:28
 * 类说明
 */
public class MaxSubArrayTest {
    
    @Test
    public void testMaxSumIncrease() {
        int[] arr = {1, -2, 3, -4, 5, -6, 7};
        Assert.assertEquals(2, MaxSubArray.maxSumIncrease(arr, 0, 3));
        Assert.assertEquals(3, MaxSubArray.maxSumIncrease(arr, 0, 5));
        Assert.assertEquals(4, MaxSubArray.maxSumIncrease(arr, 0, 6));
    }
    
    @Test
    public void testMaxSumDecrease() {
        int[] arr = {1, -2, 3, -4, 5, -6, 7};
        Assert.assertEquals(7, MaxSubArray.maxSumDecrease(arr, 6, 0));
        Assert.assertEquals(7, MaxSubArray.maxSumDecrease(arr, 6, 1));
        Assert.assertEquals(7, MaxSubArray.maxSumDecrease(arr, 6, 2));
    }
    
    @Test
    public void testMaxSum() {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Assert.assertEquals(43, MaxSubArray.maxSub(arr, 0, arr.length - 1));
    }
}
