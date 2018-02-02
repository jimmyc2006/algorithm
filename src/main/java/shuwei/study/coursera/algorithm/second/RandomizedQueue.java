package shuwei.study.coursera.algorithm.second;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author shuwei
 * @version 创建时间：2018年1月31日 上午11:21:29 类说明
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;
    private int head;
    private int index;
    private int capacity;


    private static final int DETAULT_CAPACITY = 10;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[DETAULT_CAPACITY];
        capacity = DETAULT_CAPACITY;
        this.head = 0;
        this.index = 0;
        this.size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        addCheckCapacity();
        size++;
        queue[index] = item;
        this.index = nextIndex(this.index);
    }

    private int nextIndex(int curIndex) {
        if (curIndex == capacity - 1) {
            curIndex = 0;
        } else {
            curIndex++;
        }
        return curIndex;
    }

    private void addCheckCapacity() {
        if (size + 1 >= capacity) {
            this.copyArray(2 * this.capacity);
        }
    }

    private void remCheckCapacity() {
        if (size - 1 <= capacity / 4 && capacity > DETAULT_CAPACITY) {
            this.copyArray(capacity / 2);
        }
    }

    private void copyArray(int newCapacity) {
        Item[] newQueue = (Item[]) new Object[newCapacity];
        int newIndex = 0;
        int curr = head;
        for (; newIndex < size; newIndex++) {
            newQueue[newIndex] = queue[curr];
            curr = this.nextIndex(curr);
        }
        this.index = newIndex;
        this.head = 0;
        this.queue = newQueue;
        this.capacity = newCapacity;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        remCheckCapacity();
        int rand = randomIndex();
        Item cur = this.queue[rand];
        index--;
        this.queue[rand] = this.queue[index];
        this.queue[index] = null;
        size--;
        return cur;
    }
    
    private int randomIndex() {
        int rand = StdRandom.uniform(size) + head;
        if (rand >= capacity) {
            rand = rand % capacity;
        }
        return rand;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.queue[randomIndex()];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return this.new RqIterator();
    }

    private class RqIterator implements Iterator<Item> {
        private Item[] randItems;
        private int current;

        public RqIterator() {
            randItems = (Item[]) new Object[size];
            int curr = head;
            for (int i = 0; i < size; i++) {
                randItems[i] = queue[curr];
                curr = nextIndex(curr);
            }
            StdRandom.shuffle(randItems);
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < randItems.length;
        }

        @Override
        public Item next() {
            if (current >= randItems.length) {
                throw new NoSuchElementException();
            }
            return randItems[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
