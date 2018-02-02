package shuwei.study.algorithm.c1s5;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] leaves;
    private int[] max;
    
    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        leaves = new int[N];
        max = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            max[i] = i;
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
        if(leaves[i] > leaves[j]) {
            id[j] = i;
            leaves[i] += leaves[j];
            if(max[i] < max[j]) {
                max[i] = max[j];
            }
        } else {
            id[i] = j;
            leaves[j] += leaves[i];
            if(max[j] < max[i]) {
                max[j] = max[i];
            }
        }
    }
    public static void main(String[] args) {
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(10);
        wqu.union(1, 2);
        wqu.union(7, 2);
        
        wqu.union(5, 6);
        wqu.union(0, 6);
        wqu.union(1, 6);
        
        wqu.union(3, 4);
        wqu.union(8, 4);
        wqu.union(9, 4);
        
        int length = wqu.id.length;
        for(int i = 0; i < length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < length; i++) {
            System.out.print(wqu.root(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < length; i++) {
            System.out.print(wqu.max[wqu.root(i)] + " ");
        }
    }
}
