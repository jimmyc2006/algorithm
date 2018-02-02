
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.second.RandomizedQueue;

/**
 * @author shuwei
 * @version 创建时间：2018年1月31日 下午9:15:58
 * 类说明
 */
public class TestRandomizedQueue {
    
    @Test
    public void testEnqueue() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        Assert.assertTrue(rq.isEmpty());
        for(int i = 0; i < 33; i++) {
            rq.enqueue("" + i);
        }
        Assert.assertEquals(33, rq.size());
    }
    
    @Test
    public void testIteraotr() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        Set<String> all = new HashSet<>();
        for (int i = 0; i < 33; i++) {
            rq.enqueue(Integer.toString(i));
            all.add(Integer.toString(i));
        }
        Assert.assertEquals(33, rq.size());
        for (String str : rq) {
            Assert.assertTrue(all.contains(str));
        }
    }
    
    @Test
    public void testSample() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        Set<String> all = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            rq.enqueue("" + i);
            all.add("" + i);
        }
        Set<String> randValues = new HashSet<>();
        Assert.assertEquals(20, rq.size());
        for(int i = 0; i < 2000; i++) {
            String r = rq.sample();
            Assert.assertTrue(all.contains(r));
            randValues.add(r);
        }
        Assert.assertTrue(randValues.containsAll(all));
    }
    
    @Test
    public void testMuti() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        for (int i = 0; i < 19; i++) {
            rq.enqueue("" + i);
        }
        Assert.assertEquals(19, rq.size());
        for (int i = 0; i < 5; i++) {
            rq.dequeue();
        }
        Assert.assertEquals(14, rq.size());
        for (int i = 19; i < 24; i++) {
            rq.enqueue("" + i);
        }
        rq.enqueue("24");
        int ss = rq.size();
        for (int i = 0; i < ss - 1; i++) {
            rq.dequeue();
        }
    }
    
    @Test
    public void testDequeue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        Set<Integer> all = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            rq.enqueue(i);
            all.add(i);
        }
        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(all.remove(rq.dequeue()));
        }
        Assert.assertTrue(rq.isEmpty());
        Assert.assertTrue(all.isEmpty());
    }
    
    @Test   // 边界值没有测试好,只有一个元素时候的sample没有测试好
    public void testAdditional() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(469);
        Assert.assertEquals(469, rq.dequeue().intValue());
        rq.enqueue(24);
        Assert.assertEquals(24, rq.dequeue().intValue());
        rq.enqueue(148);
        Assert.assertEquals(148, rq.sample().intValue());
    }
}
