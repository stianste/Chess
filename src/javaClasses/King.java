package javaClasses;

public class King extends Piece {
    protected King(boolean white, int x, int y) {
        super(white, "KI", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
