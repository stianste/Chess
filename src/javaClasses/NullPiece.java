package javaClasses;

public class NullPiece extends Piece {
    protected NullPiece(int x, int y) {
        super(false, "X", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        return false;
    }
}
