package javaClasses;

import java.util.Objects;

import static java.lang.Math.abs;

public class Queen extends Piece{
    protected Queen(boolean white, int x, int y) {
        super(white, "Q", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        // Combine the movement of the rook and the tower
        return (this.x - x == 0 || this.y - y == 0) || (abs(this.x - x) == abs(this.y - y));
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        // TODO: This ain't too pretty. It should probably be rewritten later;
        int dx, dy;
        if (this.x == x){
            dx = 0;
        } else {
            dx = this.x - x > 0 ? -1 : 1;
        }
        if (this.y == y) {
            dy = 0;
        } else {
            dy = this.y - y > 0 ? -1 : 1;
        }
        if (dx == 0){
            for (int j = this.y + dy; j != y; j += dy){
                if (!Objects.equals(grid.getStringValue(x, j), "BX")) return false;
            }
        } else if (dy == 0){
            for (int i = this.x + dx; i != x; i += dx){
                if (!Objects.equals(grid.getStringValue(i, y), "BX")) return false;
            }
        } else {
            for (int i = this.x + dx, j = this.y + dy; i != x && j != y; i += dx, j += dy){
                if (!Objects.equals(grid.getStringValue(i, j), "BX")) return false;
            }
        }
        return true;
    }
}
