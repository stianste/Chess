package javaClasses;

public class Rook extends Piece{
    protected Rook(boolean white, int x, int y) {
        super(white, "R", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // Can only move in either x or y direction
        return this.x - x == 0 || this.y - y == 0;
    }
}
