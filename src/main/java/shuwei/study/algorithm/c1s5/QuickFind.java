package shuwei.study.algorithm.c1s5;

public class QuickFind extends UF {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        if(id[p] == id[q]) {
            return;
        }
        int N = id.length;
        for(int i = 0; i < N; i++) {
            if(id[i] == id[p]) {
                id[i] = id[q];
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
