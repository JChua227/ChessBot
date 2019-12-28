package Pieces;

import java.util.*;

public class King extends Piece{

    public King(boolean playerPiece){
        super(playerPiece,1000000000);
    }

    public String toString(){
        return getPlayerPiece() + "King";
    }

    public List<Piece[][]> getPossibleMoves(Piece [][]gameBoard, int x, int y){
        List<Piece[][]> list = new ArrayList<>();
        if(x+1<gameBoard.length && y+1<gameBoard[0].length && (gameBoard[x+1][y+1]==null || gameBoard[x+1][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y+1] = king;
            list.add(possiblePosition);
        }
        if(x+1<gameBoard.length && (gameBoard[x+1][y]==null || gameBoard[x+1][y].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y] = king;
            list.add(possiblePosition);
        }
        if(x+1<gameBoard.length && y-1>-1 && (gameBoard[x+1][y-1]==null || gameBoard[x+1][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y-1] = king;
            list.add(possiblePosition);
        }
        if(y-1>-1 && (gameBoard[x][y-1]==null || gameBoard[x][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x][y-1] = king;
            list.add(possiblePosition);
        }
        if(x-1>-1 && y-1>-1 && (gameBoard[x-1][y-1]==null || gameBoard[x-1][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y-1] = king;
            list.add(possiblePosition);
        }
        if(x-1>-1 && (gameBoard[x-1][y]==null || gameBoard[x-1][y].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y] = king;
            list.add(possiblePosition);
        }
        if(x-1>-1 && y+1<gameBoard[0].length && (gameBoard[x-1][y+1]==null || gameBoard[x-1][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y+1] = king;
            list.add(possiblePosition);
        }
        if(y+1<gameBoard[0].length && (gameBoard[x][y+1]==null || gameBoard[x][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x][y+1] = king;
            list.add(possiblePosition);
        }

        return list;
    }
}
