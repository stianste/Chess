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
}
