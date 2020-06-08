package Decision;

import Pieces.King;
import Pieces.Piece;

import java.util.List;

public class Evaluator{

    public Evaluator(){

    }

    public int evaluate(Piece[][]gameBoard){
        int total = 0;
        total += sumStaticPosition(gameBoard);
        return total;
    }

    public Move evaluatePosition(Move move, String nextMove){
        int evaluation = 0;
        return new Move(move.getGameState(), evaluation, nextMove,move.getMoveList());
    }

    public int sumStaticPosition(Piece [][]gameBoard){
        int pieceCountWorth = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Piece){
                    if(gameBoard[x][y].getPlayerPiece()){
                        pieceCountWorth += gameBoard[x][y].getPieceWorth();
                    }
                    else{
                        pieceCountWorth -= gameBoard[x][y].getPieceWorth();
                    }
                }
            }
        }
        return pieceCountWorth;
    }

    public boolean gameIsFinished(Move move){
        int kingCounter=0;
        for(int x=0; x<move.getGameState().length; x++){
            for(int y=0; y<move.getGameState()[0].length; y++){
                if(move.getGameState()[x][y] instanceof King){
                    kingCounter++;
                }
                if(kingCounter==2){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkWinner(Move move){
        for(int x=0; x<move.getGameState().length; x++){
            for(int y=0; y<move.getGameState()[0].length; y++){
                if(move.getGameState()[x][y] instanceof King){
                    return !move.getGameState()[x][y].getPlayerPiece();
                }
            }
        }

        //this statement should never be reached
        return true;
    }

    public boolean checkTie(Piece[][] gameState){
        for(int x=0; x<gameState.length; x++){
            for(int y=0; y<gameState[0].length; y++){
                if(gameState[x][y]!=null){
                    if(!(gameState[x][y] instanceof King)){
                        return false;
                    }
                }
            }
        }

        return true;
    }


}