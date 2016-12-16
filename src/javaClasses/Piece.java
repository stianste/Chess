package javaClasses;

public abstract class Piece {
    protected boolean white;
    private String representation;
    protected int x;
    protected int y;

    protected Piece(boolean white, String representation, int x, int y) {
        this.white = white;
        this.representation = representation;
        this.x = x;
        this.y = y;
    }

    abstract boolean canMove(int x, int y);
    abstract boolean legalMove(Grid grid, int x, int y);

    @Override
    public String toString(){
        return (this.white) ? "W" + this.representation : "B" + this.representation;
    }

    public boolean isWhite() {
        return white;
    }

    public String getRepresentation() {
        return representation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }
}
