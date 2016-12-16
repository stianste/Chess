package javaClasses;

import static java.lang.Math.abs;

public class King extends Piece {
    protected King(boolean white, int x, int y) {
        super(white, "KI", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return (abs(this.y - y) < 2 && abs(this.x - x) < 2) && !(this.y == y && this.x == x);
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        // King can't jump over pieces, so as long as it can move
        // to a location, there will be no interfering pieces that canMove
        // does not detect
        return true;
    }
}
