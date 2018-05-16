package shuwei.study.algorithm.c1e1;

public class E1_1 {
    public static void main(String[] args) {
        // test8();
        System.out.println(int2B(10));
        System.out.println(int2B(0));
    }
    
    public static void test1() {
        System.out.println((0 + 15)/2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
    }
    
    public static void test2() {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }
    
    public static void test3() {
        int f = 0;
        int g = 1;
        for(int i = 0; i <=15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void test7() {
        double t = 9.0;
        while(Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("%.5f\n", t);
    }
    
    public static void test8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('a' + 4));
    }
    
    // 将整数转换为2进制表示，参数需要正整数
    public static String int2B(int a) {
        StringBuilder sb = new StringBuilder();
        // 将a % 2的结果放到尾巴上，然后将a赋值为a/2
        while (a != 0) {
            sb.insert(0, Math.abs(a % 2));
            a = a / 2;
        }
        return sb.toString();
    }
}
 