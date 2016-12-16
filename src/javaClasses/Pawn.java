package javaClasses;

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
                return this.y - y == 2 || this.y - y == 1;
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
        return false;
    }

    @Override
    public void move(int x, int y){
        super.move(x, y);
        this.hasMadeFirstMove = true;
    }
}
