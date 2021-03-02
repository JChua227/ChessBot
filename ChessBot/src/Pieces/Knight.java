package Pieces;

import Decision.Move;

import java.util.*;

public class Knight extends Piece{

    public Knight(boolean playerPiece){
        super(playerPiece,300);
    }

    public String toString(){
        return getPlayerPiece() + "Knight";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation, boolean validMoveChecker){

        List<Move> list = new ArrayList<>();

        possibleKnightMoves(list,x,y,2,1,gameBoard,notation);
        possibleKnightMoves(list,x,y,2,-1,gameBoard,notation);
        possibleKnightMoves(list,x,y,1,-2,gameBoard,notation);
        possibleKnightMoves(list,x,y,-1,-2,gameBoard,notation);
        possibleKnightMoves(list,x,y,-2,-1,gameBoard,notation);
        possibleKnightMoves(list,x,y,-2,1,gameBoard,notation);
        possibleKnightMoves(list,x,y,-1,2,gameBoard,notation);
        possibleKnightMoves(list,x,y,1,2,gameBoard,notation);

        return list;
    }

    public void possibleKnightMoves(List<Move> list,int x, int y,int xIncrement, int yIncrement,Piece [][]gameBoard,List<String> notation){
        if(x+xIncrement<gameBoard.length && x+xIncrement>-1 && y+yIncrement<gameBoard[0].length && y+yIncrement>-1 && (gameBoard[x+xIncrement][y+yIncrement]==null || gameBoard[x+xIncrement][y+yIncrement].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
            knight.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+xIncrement][y+yIncrement] = knight;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+xIncrement, y+yIncrement);
            Move move = new Move(x, y, x+xIncrement, y+yIncrement, possiblePosition, newNotation);
            move.setKingCaptured(isEnemyKing(gameBoard,x+xIncrement,y+yIncrement));
            list.add(move);
        }
    }
}