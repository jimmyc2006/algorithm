package shuwei.study.algorithm.c1s5;
/**
 * @author shuwei
 * @version 创建时间：2018年1月24日 上午9:35:05
 * 来自UnionFind.pdf
 */
public class QuickUnionUF {
    private int[] id;
    
    public QuickUnionUF(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
