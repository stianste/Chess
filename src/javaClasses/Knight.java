package javaClasses;

import static java.lang.Math.abs;

public class Knight extends Piece {
    protected Knight(boolean white, int x, int y) {
        super(white, "K", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return (abs(this.x - x) == 2 && abs(this.y - y) == 1) || (abs(this.x - x) == 1 && abs(this.y - y) == 2);
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        // Knight can jump over pieces, so as long as it can move
        // to a location, there will be no interfering pieces
        return true;
    }
}
