package javaClasses;

import java.util.Objects;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    protected Bishop(boolean white, int x, int y) {
        super(white, "B", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // To move vertically the delta must be the same for both x and y in either direction
        return abs(this.x - x) == abs(this.y - y);
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        int dx = this.x - x > 0 ? -1 : 1;
        int dy = this.y - y > 0 ? -1 : 1;

        for (int i = this.x + dx, j = this.y + dy; i != x && j != y; i += dx, j += dy){
            if (!Objects.equals(grid.getStringValue(i, j), "BX")) return false;
        }
        return true;
    }
}
