package shuwei.study.algorithm.c1s4;

import shuwei.study.algorithm.StdRandom;

/**
 * @author shuwei
 * @version 创建时间：2018年1月11日 上午9:33:44
 * p121倍率实验
 */
public class DoublingRatio {
    public static double timeTrial(int N)  {
        int MAX = 100-0000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for(int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.println(String.format("%6d %7.1f ", N, time));
            System.out.println(String.format("%5.1f\n", time/prev));
            prev = time;
        }
    }
}
