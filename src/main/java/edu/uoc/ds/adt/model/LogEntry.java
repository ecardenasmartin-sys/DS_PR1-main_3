package edu.uoc.ds.adt.model;

import edu.uoc.ds.adt.ISnakeGame;

public class LogEntry {
    Segment head;
    String message;
    ISnakeGame.Direction direction;

    public LogEntry(Segment _head, String _logMessage, ISnakeGame.Direction _direction){
        head = _head;
        message = _logMessage;
        direction = _direction;
    }

    public int getX() {
        return head.GetX();
    }

    public int getY() {
        return head.GetY();
    }

    public ISnakeGame.Direction getDirection() {
        return direction;
    }

    public String getMsg() {
        return message;
    }
}
