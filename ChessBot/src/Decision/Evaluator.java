package Decision;

import Pieces.Piece;

import java.util.List;

public class Evaluator{

    public Evaluator(List<String> notation){

    }

    public int evaluate(Piece[][]gameBoard){
        int total = 0;
        total += sumStaticPosition(gameBoard);
        return total;
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



}