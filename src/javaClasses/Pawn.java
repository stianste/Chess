package javaClasses;

import java.util.Objects;

import static java.lang.Math.abs;

public class Pawn extends Piece{
    private boolean hasMadeFirstMove = false;
    protected Pawn(boolean white, int x, int y) {
        super(white, "P", x, y);
    }

    @Override
    boolean canMove(int x, int y) {
        System.out.println("Trying to move from " + this.x + " " + this.y + " To " + x + " " + y);
        if (this.white){
            if (! hasMadeFirstMove){
                return this.y - y == 2 || this.y - y == 1 || (y == this.y + 1 && abs(this.x - x) == 1);
            } else {
                return this.y - y == 1;
            }
        } else {
            if (! hasMadeFirstMove){
                return ((y - this.y) == 2) || ((y - this.y) == 1);
            } else {
                this.hasMadeFirstMove = true;
                return y - this.y == 1;
            }
        }
    }

    @Override
    boolean legalMove(Grid grid, int x, int y) {
        if (this.x != x){ // The pawn is attacking
            // It can only attack if the piece is of the opposite color,
            // and can not attack if the target field is blank
            return grid.getPieceAt(x, y).isWhite() != this.isWhite()
                    && (!Objects.equals(grid.getStringValue(x, y), "BX"));
        }
        int dy = this.y - y > 0 ? -1 : 1;
        for (int i = this.y + dy; i != y; i += dy){
            if (!Objects.equals(grid.getStringValue(x, i), "BX")) return false;
        }
        return Objects.equals(grid.getStringValue(x, y), "BX");
    }

    @Override
    public void move(int x, int y){
        super.move(x, y);
        this.hasMadeFirstMove = true;
    }
}
