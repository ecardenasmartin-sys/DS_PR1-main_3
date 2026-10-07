package edu.uoc.ds.adt;

import edu.uoc.ds.adt.exceptions.SnakeOutOfBoundsException;
import edu.uoc.ds.adt.model.LogEntry;
import edu.uoc.ds.adt.model.Segment;
import edu.uoc.ds.adt.model.Snake;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.traversal.Iterator;

public class SnakeGame implements ISnakeGame {

    LinkedList<LogEntry> logs = new LinkedList<>();
    boolean isFirstTurn = true;

    char[][] board = new char[SnakeGame.BOARD_SIZE][SnakeGame.BOARD_SIZE];
    Snake snake = new Snake();

    final char TILE_EMPTY = '.';
    final char TILE_SNAKE = 'S';
    final char TILE_APPLE = '@';

    final String LOG_INIT = "Punto de inicio: {%g,%g}";
    final String LOG_MOVE = "MOVE";
    final String LOG_EAT = "EAT";
    final String LOG_OOB = "COLLISION";

    public SnakeGame() {
        for (int y = 0; y < SnakeGame.BOARD_SIZE; y++)
            for (int x = 0; x < SnakeGame.BOARD_SIZE; x++)
                board[x][y] = TILE_EMPTY;
    }

    private void SetTile(int x, int y, char tile) {
        board[x][y] = tile;
    }

    @Override
    public void addSegment(int x, int y) {
        snake.addSegment(x, y);
        SetTile(x, y, TILE_SNAKE);
    }

    @Override
    public void addSegments(int[][] segments) {
        for (int i = segments.length-1; i >= 0; i--) {
            addSegment(segments[i][0], segments[i][1]);
        }
    }

    @Override
    public int size() {
        return snake.size();
    }

    @Override
    public void addFood(int x, int y) {
        SetTile(x, y, TILE_APPLE);
    }

    @Override
    public boolean hasFoodAt(int x, int y) {
        return board[x][y] == TILE_APPLE;
    }

    @Override
    public char getSegment(int x, int y) {
        return board[x][y];
    }

    @Override
    public Segment head() {
        return snake.head();
    }

    @Override
    public Segment tail() {
        return snake.tail();
    }

    @Override
    public void move(Direction direction) throws SnakeOutOfBoundsException {
        Segment target = new Segment(snake.head().GetX() + direction.getDx(), snake.head().GetY() + direction.getDy());

        if( target.GetX() < 0 || target.GetY() < 0 ||
            target.GetX() >= SnakeGame.BOARD_SIZE || target.GetY() >= SnakeGame.BOARD_SIZE)
        {
            logs.insertEnd(new LogEntry(snake.head(), LOG_OOB, direction));
            throw new SnakeOutOfBoundsException("Snake out of bounds exception");
        }

        if(board[target.GetX()][target.GetY()] != TILE_APPLE)
            snake.deleteTail();
        else
            logs.insertEnd(new LogEntry(snake.head(), LOG_EAT, direction));

        logs.insertEnd(new LogEntry(snake.head(), LOG_MOVE, direction));

        addSegment(target.GetX(), target.GetY());
    }

    @Override
    public Iterator<LogEntry> logEntries() {
        return logs.values();
    }
}
