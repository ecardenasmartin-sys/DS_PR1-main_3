package edu.uoc.ds.adt.model;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class PR1Queue {

    public static final int CAPACITY = 15;

    private Queue<Integer> queue;

    public PR1Queue() {
        newQueue();
    }
    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<Integer> getQueue() {
        return this.queue;
    }

    public void add(int c) {
        this.queue.add(c);
    }

    public long poll() {
        return this.queue.poll();
    }
}
