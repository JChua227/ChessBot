package Decision;

import Pieces.*;

import java.util.List;

public class Evaluator{

    private static int[][]bishopWorth;
    private static int[][]knightWorth;
    private static int[][]pawnWorth;
    private static int[][]queenWorth;
    private static int[][]rookWorth;
    private static int[][]kingWorth;

    public Evaluator(){
        setBishopWorth();
        setKnightWorth();
        setPawnWorth();
        setQueenWorth();
        setRookWorth();
        setKingWorth();
    }

    public void setBishopWorth(){
        this.bishopWorth = new int[][]{
                {-20, -10, -10, -10, -10, -10, -10, -20},
                {-10, 0, 0, 0, 0, 0, 0, -10},
                {-10, 0, 7, 10, 10, 7, 0, -10},
                {-10, 7, 7, 10, 10, 7, 7, -10},
                {-10, 0, 10, 10, 10, 10, 0, -10},
                {-10, 10,10, 10, 10, 10, 10, -10},
                {-10, 7, 0, 0, 0, 0, 7, -10},
                {-20, 0, 0, 0, 0, 0, 0, -20}};
    }

    public void setKnightWorth(){
        this.knightWorth = new int[][]{
                {-30, -20, -1, -1, -1, -1, 20, -30},
                {-20, -8, -5, 2, 2, -5, -8, -20},
                {-10, -2, 10, 15, 15, 10, -2, -10},
                {-10, 2, 20, 25, 25, 2, 2, -10},
                {-10, 2, 20, 25, 25, 20, 2, -10},
                {-10, -2, 10, 20, 20, 10, -2, -10},
                {-20, -8, -5, 2, 2, -5, -8, -20},
                {-30, -20, -10, -10, -10, -10, -20, -30}};
    }

    public void setPawnWorth(){
        this.pawnWorth = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {50, 50, 50, 50, 50, 50, 50, 50},
                {10, 10, 20, 30, 30, 20, 10, 10},
                {5, 5, 10, 22, 22, 10, 5, 5},
                {0, 0, 0, 20, 20, 0, 0, 0},
                {5, -4, -10, 0, 0, -10, -4, 0},
                {5, 10, 10, 0, 0, 10, 10, 5},
                {0, 0, 0, 0, 0, 0, 0, 0}};
    }

    public void setQueenWorth(){
        this.queenWorth = new int[][]{
                {-20, -10, -10, -5, -5, -10, -10, -20},
                {-10, 0, 0, 0, 0, 0, 0, -10},
                {-10, 0, 5, 5, 5, 5, 0, -10},
                {-5, 0, 5, 5, 5, 5, 0, -5},
                {0, 0, 5, 5, 5, 5, 0, -5},
                {-10, 5, 5, 5, 5, 5, 0, -10},
                {-10, 0, 5, 0, 0, 0, 0, -10},
                {-20, -10, -10, -5, -5, -10, -10, -20}};
    }

    public void setRookWorth(){
        this.rookWorth = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {5, 10, 10, 10, 10, 10, 10, 5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {0, 0, 0, 5, 5, 0, 0, 0}};
    }

    public void setKingWorth(){
        this.kingWorth = new int[][]{
                {-30, -40, -40, -50, -50, -40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-20, -30, -30, -40, -40,-30, -30, -20},
                {-10, -20, -20, -20, -20,-20, -20, -10},
                {20, 20, 0, 0, 0, 0, 20, 20},
                {20, 30, 10, 0, 0, 10, 30, 20}};
    }

    public int[][] getBishopWorth(){
        return this.bishopWorth;
    }

    public int[][] getKnightWorth(){
        return this.knightWorth;
    }

    public int[][] getPawnWorth(){
        return this.pawnWorth;
    }

    public int[][] getQueenWorth(){
        return this.queenWorth;
    }

    public int[][] getRookWorth(){
        return this.rookWorth;
    }

    public int[][] getKingWorth(){
        return this.kingWorth;
    }

    public int evaluate(Piece[][]gameBoard){
        int total = 0;
        total += sumStaticPosition(gameBoard);
        total += sumPositionalWorth(gameBoard);
        return total;
    }

    public Move evaluatePosition(Move move, String nextMove){
        return new Move(move.getGameState(), evaluate(move.getGameState()), nextMove,move.getMoveList());
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

    public int sumPositionalWorth(Piece [][]gameBoard){
        int worth = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y]!=null){
                    if(gameBoard[x][y] instanceof Bishop){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getBishopWorth()[x][y];
                        else{
                            worth -= getBishopWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Knight){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getKnightWorth()[x][y];
                        else{
                            worth -= getKnightWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Pawn){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getPawnWorth()[x][y];
                        else{
                            worth -= getPawnWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Queen){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getQueenWorth()[x][y];
                        else{
                            worth -= getQueenWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Rook){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getRookWorth()[x][y];
                        else{
                            worth -= getRookWorth()[x][y];
                        }
                    }
                    if(gameBoard[x][y] instanceof King){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getKingWorth()[x][y];
                        else{
                            worth -= getKingWorth()[x][y];
                        }
                    }
                }
            }
        }

        return worth;
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