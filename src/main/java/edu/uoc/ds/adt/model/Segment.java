package edu.uoc.ds.adt.model;

import java.util.Arrays;

public class Segment {
    private final int[] position;

    public Segment(int x, int y) {
        position = new int[] {x, y};
    }

    public int GetX() {
        return position[0];
    }

    public int GetY() {
        return position[1];
    }

    // src: https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        final Segment other = (Segment) obj;

        return Arrays.equals(this.position, other.position);
    }
}
