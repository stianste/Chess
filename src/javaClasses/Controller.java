package javaClasses;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ResourceBundle;

import static java.util.stream.IntStream.*;

public class Controller implements Initializable {
    /*
    x = empty
    P = pawn
    R = rook
    K = knight
    B = bishop
    Q = queen
    KI = king
     */
    @FXML private Pane mainPane;
    private Grid grid;
    private Rectangle selection;
    private boolean selected = false;
    private Piece currentPiece;
    private boolean whitesTurn = true;

    private void start(){
        this.grid = new Grid();
        this.drawSquares();
        this.drawPieces();
        this.mainPane.setOnMouseClicked(e -> {
            int x = (int) (e.getX()/Constants.squareWidth);
            int y = (int) (e.getY()/Constants.squareHeight);
            if (this.selected){
                this.handleMovePiece(x,y);
                this.selected = false;
                //TODO Only update one picture intead of redrawing all of them
                this.drawPieces();
            } else {
                this.handleSelection(x,y);
            }
            //System.out.println(this.grid.toString());
        });
    }

    private void handleMovePiece(int x, int y) {
        this.grid.movePiece(this.currentPiece, x, y);
        this.whitesTurn = !this.whitesTurn;
        this.drawPieces();
    }

    private void handleSelection(int x, int y) {
        this.mainPane.getChildren().remove(this.selection);
        this.currentPiece = this.grid.getPieceAt(x, y);

        if (this.currentPiece.toString().charAt(1) == 'X'
                || this.currentPiece.isWhite() != this.whitesTurn) return;

        this.selection = new Rectangle(x*Constants.squareWidth, y*Constants.squareHeight, Constants.squareWidth,Constants.squareHeight);
        this.selection.setFill(Constants.selectColor);
        this.selection.setOpacity(Constants.selectOpacity);
        this.mainPane.getChildren().addAll(this.selection);
        this.selected = true;

    }

    private void drawPieces() {
        this.mainPane.getChildren().removeIf(child -> child instanceof ImageView);
        range(0,8).forEach( x -> range(0,8).forEach( y -> {
            String url = "";
                switch ( this.grid.getStringValue(x,y) ){
                    case "BR": url = "resources/black_rook.png"; break;
                    case "BK": url = "resources/black_knight.png"; break;
                    case "BB": url = "resources/black_bishop.png"; break;
                    case "BQ": url = "resources/black_queen.png"; break;
                    case "BKI": url = "resources/black_king.png"; break;
                    case "BP": url = "resources/black_pawn.png"; break;

                    case "WR": url = "resources/white_rook.png"; break;
                    case "WK": url = "resources/white_knight.png"; break;
                    case "WB": url = "resources/white_bishop.png"; break;
                    case "WQ": url = "resources/white_queen.png"; break;
                    case "WKI": url = "resources/white_king.png"; break;
                    case "WP": url = "resources/white_pawn.png"; break;
                    default: url = "";
                }
            if (url != ""){
                Image img = new Image(url, Constants.squareWidth, Constants.squareHeight, true, true);
                ImageView iv1 = new ImageView(img);
                iv1.setX(x*Constants.squareHeight);
                iv1.setY(y*Constants.squareHeight);
                this.mainPane.getChildren().addAll(iv1);
            }

        }));
    }

    private void drawSquares() {
        Color col;
        range(0,8).forEach( x -> range(0,8).forEach( y -> {
            Rectangle rekt = new Rectangle(x*Constants.squareWidth, y*Constants.squareHeight, Constants.squareWidth, Constants.squareHeight);
            this.mainPane.getChildren().addAll(rekt);
            if((x + y) % 2 == 0 ){
                rekt.setFill(Constants.squareColor1);
            } else {
                rekt.setFill(Constants.squareColor2);
            }
            }));
   }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        start();
    }
}
