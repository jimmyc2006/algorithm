package shuwei.study.coursera.algorithm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author shuwei
 * @version 创建时间：2018年2月4日 上午11:24:10
 * 类说明
 */
public class SortUtil {
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i + 1], arr[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for(int i = lo; i < hi; i++) {
            if (less(arr[i + 1], arr[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }
    public static <T> void swap(Comparable<T>[] arr, int x, int y) {
        Comparable<T> tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    
    private static final Random rand = new Random(System.currentTimeMillis());
    
    public static Integer[] generate(int length) {
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        shuffle(result);
        // 洗牌算法
        return result;
    }
    
    public static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1);
            swap(a, i, r);
        }
    }
    public static void myShuffle(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i ++) {
            swap(a, i, rand.nextInt(i + 1));
        }
    }
    
    public static void main(String[] args) {
        int length = 10;
        Map<Integer, Map<Integer, Integer>> tongji = new HashMap<>();   // key是数字，value是在位置x出现的次数
        int loops = 100000;
        for (int k = 0; k < loops; k++) {
            Integer[] testData = new Integer[length];
            for (int i = 0; i < length; i++) {
                testData[i] = i;
            }
            myShuffle(testData);
            for (int i = 0; i < length; i++) {
                Map<Integer, Integer> positionAndTimes = tongji.get(testData[i]);
                if (positionAndTimes == null) {
                    positionAndTimes = new HashMap<>();
                    tongji.put(testData[i], positionAndTimes);
                }
                Integer times = positionAndTimes.get(i);
                if (times == null) {
                    positionAndTimes.put(i, 1);
                } else {
                    positionAndTimes.put(i, times + 1);
                }
            }
        }
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : tongji.entrySet()) {
            int number = entry.getKey();
            for (Map.Entry<Integer, Integer> ent : entry.getValue().entrySet()) {
                System.out.println(number + "在" + ent.getKey() + " 出现的概率是:" + ((double)ent.getValue() / loops));
            }
        }
    }
}
