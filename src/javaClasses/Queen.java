package javaClasses;

import static java.lang.Math.abs;

public class Queen extends Piece{
    protected Queen(boolean white, int x, int y) {
        super(white, "Q", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // Combine the movement of the rook and the tower
        return (this.x - x == 0 || this.y - y == 0) || (abs(this.x - x) == abs(this.y - y));
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        return false;
    }
}
