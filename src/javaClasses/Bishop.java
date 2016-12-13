package javaClasses;

public class Bishop extends Piece{
    protected Bishop(boolean white, int x, int y) {
        super(white, "B", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
