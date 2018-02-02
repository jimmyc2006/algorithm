package shuwei.study.algorithm.c1s5;
public class Successor {
    private int[] after;
    private int[] before;
    private static final int DELETED = -10;

    public Successor(int n) {
        after = new int[n];
        before = new int[n];
        for(int i = 0; i < n; i++) {
          after[i] = i + 1;
          before[i] = i - 1;
        }
    }
    
    public void delete(int i) {
        after[before[i]] = after[i];
        before[after[i]] = before[i];
    }
    
    public int getSuccessor(int i) {
        return after[i];
    }
    
    public void printInfo() {
        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++) {
            System.out.print(after[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++) {
            System.out.print(before[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        Successor s = new Successor(10);
        s.printInfo();
        s.delete(3);
        System.out.println(s.getSuccessor(2));
        s.printInfo();
    }
}
