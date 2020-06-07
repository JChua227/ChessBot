package Pieces;

import Decision.Move;

import java.util.*;

public class Knight extends Piece{

    public Knight(boolean playerPiece){
        super(playerPiece,30);
    }

    public String toString(){
        return getPlayerPiece() + "Knight";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        List<Move> list = new ArrayList<>();

        if(x+2<gameBoard.length && y+1<gameBoard[0].length && (gameBoard[x+2][y+1]==null || gameBoard[x+2][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+2][y+1] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+2, y+1);
            Move move = new Move(x, y, x+2, y+1, possiblePosition, newNotation);
            list.add(move);
        }
        if(x+2<gameBoard.length && y-1>-1 && (gameBoard[x+2][y-1]==null || gameBoard[x+2][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+2][y-1] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+2, y-1);
            Move move = new Move(x, y, x+2, y-1, possiblePosition, newNotation);
            list.add(move);
        }
        if(x+1<gameBoard.length && y-2>-1 && (gameBoard[x+1][y-2]==null || gameBoard[x+1][y-2].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y-2] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+1, y-2);
            Move move = new Move(x, y, x+1, y-2, possiblePosition, newNotation);
            list.add(move);
        }
        if(x-1>-1 && y-2>-1 && (gameBoard[x-1][y-2]==null || gameBoard[x-1][y-2].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y-2] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-1, y-2);
            Move move = new Move(x, y, x-1, y-2, possiblePosition, newNotation);
            list.add(move);
        }
        if(x-2>-1 && y-1>-1 && (gameBoard[x-2][y-1]==null || gameBoard[x-2][y-1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-2][y-1] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-2, y-1);
            Move move = new Move(x, y, x-2, y-1, possiblePosition, newNotation);
            list.add(move);
        }
        if(x-2>-1 && y+1<gameBoard[0].length && (gameBoard[x-2][y+1]==null || gameBoard[x-2][y+1].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-2][y+1] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-2, y+1);
            Move move = new Move(x, y, x-2, y+1, possiblePosition,newNotation);
            list.add(move);
        }
        if(x-1>-1 && y+2<gameBoard[0].length && (gameBoard[x-1][y+2]==null || gameBoard[x-1][y+2].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x-1][y+2] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x-1, y+2);
            Move move = new Move(x, y, x-1, y+2, possiblePosition, newNotation);
            list.add(move);
        }
        if(x+1<gameBoard.length && y+2<gameBoard[0].length && (gameBoard[x+1][y+2]==null || gameBoard[x+1][y+2].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+1][y+2] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+1, y+2);
            Move move = new Move(x, y, x+1, y+2, possiblePosition, newNotation);
            list.add(move);
        }
        return list;
    }
}