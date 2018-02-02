import org.junit.Assert;
import org.junit.Test;

import shuwei.study.coursera.algorithm.second.Deque;

/**
 * @author shuwei
 * @version 创建时间：2018年1月31日 下午1:53:37
 * 类说明
 */
public class TestDeque {

    @Test(expected= IllegalArgumentException.class) 
    public void testAddFirst() {
        Deque<String> q = new Deque<>();
        q.addFirst(null);
    }
    
    @Test
    public void testAddFirst2() {
        Deque<String> q = new Deque<>();
        Assert.assertTrue(q.isEmpty());
        q.addFirst("aaa");
        Assert.assertEquals(1, q.size());
        Assert.assertEquals(false, q.isEmpty());
        q.addFirst("bbb");
        q.addFirst("ccc");
        Assert.assertEquals(3, q.size());
    }
    
    @Test
    public void testAddLast() {
        Deque<String> q = new Deque<>();
        q.addLast("zzz");
        Assert.assertEquals(1, q.size());
        Assert.assertEquals(false, q.isEmpty());
        Assert.assertEquals("zzz", q.removeFirst());
        Assert.assertTrue(q.isEmpty());
        Assert.assertEquals(0, q.size());
    }
    
    @Test
    public void testAppend1() {
        Deque<Integer> q = new Deque<>();
        q.addFirst(0);
        Assert.assertEquals(0, q.removeLast().intValue());
        Assert.assertTrue(q.isEmpty());
        q.addFirst(3);
        Assert.assertEquals(3, q.removeLast().intValue());
    }
    
    @Test
    public void testAddAndRemove() {
        Deque<String> q = new Deque<>();
        q.addLast("xxx");
        q.addLast("yyy");
        q.addLast("zzz");
        q.addFirst("ccc");
        q.addFirst("bbb");
        q.addFirst("aaa");
        Assert.assertEquals(6, q.size());
        int  i = 0;
        String[] result = {"aaa", "bbb", "ccc", "xxx", "yyy", "zzz"};
        for(String str : q) {
            Assert.assertEquals(result[i++], str);
        }
        Assert.assertEquals("aaa", q.removeFirst());
        Assert.assertEquals("zzz", q.removeLast());
        Assert.assertEquals("yyy", q.removeLast());
        Assert.assertEquals("xxx", q.removeLast());
        Assert.assertEquals("ccc", q.removeLast());
        Assert.assertEquals("bbb", q.removeLast());
        Assert.assertTrue(q.isEmpty());
        q.addFirst("hhh");
        Assert.assertEquals(1, q.size());
    }
}
