package shuwei.study.coursera.algorithm.second;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author shuwei
 * @version 创建时间：2018年1月31日 上午11:56:21 类说明
 */
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            rq.enqueue(item);
        }
        int times = Integer.parseInt(args[0]);
        for (int i = 0; i < times; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
