package javaClasses;

public class Queen extends Piece{
    protected Queen(boolean white, int x, int y) {
        super(white, "Q", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
