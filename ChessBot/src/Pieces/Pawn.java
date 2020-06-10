package Pieces;

import Decision.Move;

import java.util.*;

public class Pawn extends Piece{

    public Pawn(boolean playerPiece){
        super(playerPiece,100);
    }

    public String toString(){
        return getPlayerPiece() + "Pawn";
    }

    //TODO: get all possible moves for pawns
    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        int forward = -1;
        if(!gameBoard[x][y].getPlayerPiece()){
            forward = 1;
        }

        List<Move> list = new ArrayList<>();

        if(x+forward>-1 && x+forward<gameBoard.length && gameBoard[x+forward][y]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            pawn.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+forward][y] = pawn;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+forward, y);
            Move move = new Move(x, y, x+forward, y, possiblePosition, newNotation);
            list.add(move);
        }
        System.out.println(gameBoard[x][y].getPlayerPiece() + " " + x + " " + y + " " + forward + " " + gameBoard[x][y].getMoved());
        if(!gameBoard[x][y].getMoved() && gameBoard[x+forward][y]==null && gameBoard[x+forward+forward][y]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            pawn.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+forward+forward][y] = pawn;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+forward+forward, y);
            Move move = new Move(x, y, x+forward+forward, y, possiblePosition, newNotation);
            list.add(move);
        }

        if(x+forward>-1 && x+forward<gameBoard.length && y-1>-1 && gameBoard[x+forward][y-1]!=null && gameBoard[x][y].getPlayerPiece()!=gameBoard[x+forward][y-1].getPlayerPiece()){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            pawn.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+forward][y-1] = pawn;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+forward, y-1);
            Move move = new Move(x, y, x+forward, y-1, possiblePosition, newNotation);
            list.add(move);
        }

        if(x+forward>-1 && x+forward<gameBoard.length && y+1<gameBoard[0].length && gameBoard[x+forward][y+1]!=null && gameBoard[x][y].getPlayerPiece()!=gameBoard[x+forward][y+1].getPlayerPiece()){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            pawn.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+forward][y+1] = pawn;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+forward, y+1);
            Move move = new Move(x, y, x+forward, y+1, possiblePosition, newNotation);
            list.add(move);
        }

        return list;
    }


}