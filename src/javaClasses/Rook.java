package javaClasses;

public class Rook extends Piece{
    protected Rook(boolean white, int x, int y) {
        super(white, "R", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
