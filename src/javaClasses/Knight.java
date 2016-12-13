package javaClasses;

public class Knight extends Piece {
    protected Knight(boolean white, int x, int y) {
        super(white, "K", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
