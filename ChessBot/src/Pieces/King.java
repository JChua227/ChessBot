package Pieces;

import Decision.Move;

import java.util.*;

public class King extends Piece{

    public King(boolean playerPiece){
        super(playerPiece,0);
    }

    public String toString(){
        return getPlayerPiece() + "King";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        List<Move> list = new ArrayList<>();
        if(x+1<gameBoard.length && y+1<gameBoard[0].length && (gameBoard[x+1][y+1]==null || gameBoard[x+1][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y+1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+1, y+1);
            Move move = new Move(x, y, x+1, y+1, possiblePosition,newNotation);
            list.add(move);
        }
        if(x+1<gameBoard.length && (gameBoard[x+1][y]==null || gameBoard[x+1][y].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+1, y);
            Move move = new Move(x, y, x+1, y, possiblePosition, newNotation);
            list.add(move);
        }
        if(x+1<gameBoard.length && y-1>-1 && (gameBoard[x+1][y-1]==null || gameBoard[x+1][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y-1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+1, y-1);
            Move move = new Move(x, y, x+1, y-1, possiblePosition, newNotation);
            list.add(move);
        }
        if(y-1>-1 && (gameBoard[x][y-1]==null || gameBoard[x][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x][y-1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x, y-1);
            Move move = new Move(x, y, x, y-1, possiblePosition,newNotation);
            list.add(move);
        }
        if(x-1>-1 && y-1>-1 && (gameBoard[x-1][y-1]==null || gameBoard[x-1][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y-1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-1, y-1);
            Move move = new Move(x, y, x-1, y-1, possiblePosition,newNotation);
            list.add(move);
        }
        if(x-1>-1 && (gameBoard[x-1][y]==null || gameBoard[x-1][y].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-1, y);
            Move move = new Move(x, y, x-1, y, possiblePosition,newNotation);
            list.add(move);
        }
        if(x-1>-1 && y+1<gameBoard[0].length && (gameBoard[x-1][y+1]==null || gameBoard[x-1][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y+1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-1, y+1);
            Move move = new Move(x, y, x-1, y+1, possiblePosition,newNotation);
            list.add(move);
        }
        if(y+1<gameBoard[0].length && (gameBoard[x][y+1]==null || gameBoard[x][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x][y+1] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x, y+1);
            Move move = new Move(x, y, x, y+1, possiblePosition,newNotation);
            list.add(move);
        }

        return list;
    }
}
