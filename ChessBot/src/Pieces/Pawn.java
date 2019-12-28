package Pieces;

import java.util.*;

public class Pawn extends Piece{

    public Pawn(boolean playerPiece){
        super(playerPiece,10);
    }

    public String toString(){
        return getPlayerPiece() + "Pawn";
    }

    //TODO: get all possible moves for pawns
    public List<Piece[][]> getPossibleMoves(Piece [][]gameBoard, int x, int y){
        int forward = -1;
        if(!gameBoard[x][y].getPlayerPiece()){
            forward = 1;
        }

        List<Piece[][]> list = new ArrayList<>();

        if(x+forward>-1 && x+forward<gameBoard.length && gameBoard[x+forward][y]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[x+forward][y] = pawn;
            list.add(possiblePosition);
        }




        return list;
    }


}