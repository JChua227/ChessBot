package Pieces;

import Decision.Move;

import java.util.*;

public class Pawn extends Piece{

    public Pawn(boolean playerPiece){
        super(playerPiece,10);
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
            pawn.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[x+forward][y] = pawn;
            Move move = new Move(x, y, x+forward, y, possiblePosition);
            list.add(move);
        }




        return list;
    }


}