package shuwei.study.coursera.algorithm.second;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author shuwei
 * @version 创建时间：2018年1月31日 上午11:06:35 类说明
 */
public class Deque<Item> implements Iterable<Item> {
    private int size = 0;
    private Node first = null;
    private Node end = null;

    public Deque() {

    }
    
    private class Node {
        public Node(Item item) {
            this.item = item;
        }

        Node pre;
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (first == null) {
            first = new Node(item);
            end = first;
        } else {
            Node n = new Node(item);
            n.next = first;
            first.pre = n;
            first = n;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (end == null) {
            first = new Node(item);
            end = first;
        } else {
            Node n = new Node(item);
            end.next = n;
            n.pre = end;
            end = n;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node tmp = first;
        first = first.next;
        if (first != null) {
            first.pre = null;
        } else {
            end = null;
        }
        size--;
        return tmp.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (end == null) {
            throw new NoSuchElementException();
        }
        Node tmp = end;
        end = end.pre;
        if (end != null) {
            end.next = null;
        } else {
            first = null;
        }
        size--;
        return tmp.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return this.new DqIterator();
    }

    private class DqIterator implements Iterator<Item> {
        private Node current;

        public DqIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Node tmp = current;
            current = current.next;
            return tmp.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
