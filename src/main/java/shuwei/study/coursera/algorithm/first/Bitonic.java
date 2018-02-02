package shuwei.study.coursera.algorithm.first;
/**
 * @author shuwei
 * @version 创建时间：2018年1月26日 上午9:10:09
 * 类说明
 */
public class Bitonic {
    int[] a = {1, 3, 5, 9, 8, 4, 0};
    
    public int find_peak()
    {
        int lo = 0, hi = a.length-1;
        // Invariant: lo <= peak <= hi 
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (a[mid] < a[mid+1]) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
    
    public boolean simple_search(int key)
    {
        int lo = 0, hi = a.length-1;
        int peak = find_peak();
        return false;
        /*
        return left_search(key, lo, peak+1) || 
               right_search(key, peak, hi);
        */
    }
    
    public static void main(String[] args) {
        Bitonic b = new Bitonic();
        System.out.println(b.find_peak());
    }
}
