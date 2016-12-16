package javaClasses;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    protected Bishop(boolean white, int x, int y) {
        super(white, "B", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // To move vertically the delta must be the same for both x and y in either direction
        return abs(this.x - x) == abs(this.y - y);
    }
}
