package javaClasses;

import java.util.Objects;

public class Rook extends Piece{
    protected Rook(boolean white, int x, int y) {
        super(white, "R", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // Can only move in either x or y direction
        return this.x - x == 0 || this.y - y == 0;
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        if (this.x - x == 0){
            int dy = this.y - y > 0 ? -1 : 1;
            for (int i = this.y + dy; i != y; i += dy){
                if (!Objects.equals(grid.getStringValue(x, i), "BX")) return false;
            }
        } else {
            int dx = this.x - x > 0 ? -1 : 1;
            for (int i = this.x + dx; i != x; i += dx) {
                if (!Objects.equals(grid.getStringValue(i, y), "BX")) return false;
            }
        }
        return true;
    }
}
