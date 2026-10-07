package edu.uoc.ds.adt.model;

import edu.uoc.ds.adt.sequential.LinkedList;

public class Snake implements ISnake{

    LinkedList<Segment> segments = new LinkedList<Segment>();

    @Override
    public Segment head() {
        return segments.peekFirst();
    }

    @Override
    public Segment tail() {
        return segments.peekLast();
    }

    @Override
    public void addSegment(int x, int y) {
        addHead(new Segment(x, y));
    }

    @Override
    public void addHead(Segment newHead) {
        segments.insertBeginning(newHead);
    }

    @Override
    public Segment deleteTail() {
        return segments.deleteLast();
    }

    @Override
    public int size() {
        return segments.size();
    }
}
