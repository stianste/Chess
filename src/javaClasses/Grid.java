package javaClasses;

import java.util.stream.IntStream;

public class Grid {
    /*
    x = empty
    P = pawn
    R = rook
    K = knight
    B = bishop
    Q = queen
    KI = king
     */
    private Piece[][] grid = new Piece[8][8];

    public Grid(){
        fillGrid();
    }

    private void fillGrid(){
        IntStream.range(0,8).forEach(i -> IntStream.range(0,8).forEach(j -> this.grid[i][j] = new NullPiece(j,i)));
        //Black pieces
        this.grid[0][0] = new Rook(false, 0,0);
        this.grid[0][7] = new Rook(false, 7,0);
        this.grid[0][1] = new Knight(false, 1,0);
        this.grid[0][6] = new Knight(false, 6,0);
        this.grid[0][2] = new Bishop(false, 2,0);
        this.grid[0][5] = new Bishop(false, 5,0);
        this.grid[0][3] = new Queen(false, 3,0);
        this.grid[0][4] = new King(false, 4,0);
        IntStream.range(0,8).forEach(i -> this.grid[1][i] = new Pawn(false, i, 1));

        //White pieces
        this.grid[7][0] = new Rook(true, 0,7);
        this.grid[7][7] = new Rook(true, 7,7);
        this.grid[7][1] = new Knight(true, 1,7);
        this.grid[7][6] = new Knight(true, 6,7);
        this.grid[7][2] = new Bishop(true, 2,7);
        this.grid[7][5] = new Bishop(true, 5,7);
        this.grid[7][3] = new Queen(true, 3,7);
        this.grid[7][4] = new King(true, 4,7);
        IntStream.range(0,8).forEach(i -> this.grid[6][i] = new Pawn(true, i, 6));
    }

    public Piece getPieceAt(int x, int y){
        return this.grid[y][x];
    }

    public String getStringValue(int x, int y){
        if (this.grid[y][x] == null){
            return "";
        }
        return this.grid[y][x].toString();
    }

    public void movePiece(Piece piece, int x, int y) {
        if(piece.canMove(x, y)){
            // Switch pieces
            Piece temp = this.grid[piece.getY()][piece.getX()];
            this.grid[piece.getY()][piece.getX()] = this.grid[y][x];
            this.grid[y][x] = temp;

            piece.move(x,y);

            System.out.println("Can move");
        } else {
            System.out.println("Can not move");
        }
    }
    public String toString(){
        String s = "";
        for (int i = 0; i < this.grid.length; i++){
            for (int j = 0; j < this.grid.length; j++){
                s += "|" + this.grid[i][j] + "|";
                if (j == 7) s += "\n--------------------------------\n";
            }
        }
        return s;
    }
}
