package shuwei.study.algorithm.c1s5;

import java.util.stream.IntStream;

/**
 * @author shuwei
 * @version 创建时间：2018年1月10日 下午9:37:39
 * p139
 */
public class UF {
    protected int[] id;
    protected int count;
    
    public UF(int N) {
        count = N;
        IntStream.range(0, N).forEach(i -> id[i] = i);
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) {
            return;
        }
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
