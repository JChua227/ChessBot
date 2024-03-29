package Decision;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Move {

    private int xSelectedPosition;
    private int ySelectedPosition;
    private int xLandedPosition;
    private int yLandedPosition;
    private Piece[][] gameState;
    private int extraTakePieceDepth = 0;
    private int evaluation;
    private List<String> moveList;
    private String nextMove;
    private boolean validMove = true;
    private int kingCaptured;
    private int numberOfMoves;

    public Move(int xSelectedPosition, int ySelectedPosition, int xLandedPosition, int yLandedPosition, Piece[][] gameState, int evaluation){
        this.xSelectedPosition = xSelectedPosition;
        this.ySelectedPosition = ySelectedPosition;
        this.xLandedPosition = xLandedPosition;
        this.yLandedPosition = yLandedPosition;
        this.gameState = gameState;
        this.evaluation = evaluation;
    }

    public Move(int xSelectedPosition, int ySelectedPosition, int xLandedPosition, int yLandedPosition, Piece[][] gameState,List<String> moveList){
        this.xSelectedPosition = xSelectedPosition;
        this.ySelectedPosition = ySelectedPosition;
        this.xLandedPosition = xLandedPosition;
        this.yLandedPosition = yLandedPosition;
        this.gameState = gameState;
        this.moveList = moveList;
    }

    public Move(Piece[][] gameState, int evaluation,String nextMove,List<String> moveList,int numberOfMoves){
        this.gameState = gameState;
        this.evaluation = evaluation;
        this.nextMove = nextMove;
        this.moveList = moveList;
        this.numberOfMoves = numberOfMoves;
    }

    public Move(Piece[][] gameState, int evaluation,String nextMove){
        this.gameState = gameState;
        this.evaluation = evaluation;
        this.nextMove = nextMove;
    }

    public Move(){

    }

    public int getXSelectedPosition(){
        return this.xSelectedPosition;
    }

    public void setXSelectedPosition(int x){
        this.xSelectedPosition = x;
    }

    public int getYSelectedPosition(){
        return this.ySelectedPosition;
    }

    public void setYSelectedPosition(int y){
        this.ySelectedPosition = y;
    }

    public int getXLandedPosition(){
        return this.xLandedPosition;
    }

    public void setXLandedPosition(int x){
        this.xLandedPosition = x;
    }

    public int getYLandedPosition(){
        return this.yLandedPosition;
    }

    public void setyLandedPosition(int y){
        this.yLandedPosition = y;
    }

    public Piece[][] getGameState(){
        return this.gameState;
    }

    public int getExtraTakePieceDepth(){
        return this.extraTakePieceDepth;
    }

    public void incrementTakePieceDepth(){
        this.extraTakePieceDepth++;
    }

    public double getEvaluation(){
        return (double)this.evaluation/100;
    }

    public void setMoveList(String s){
        this.moveList.add(s);
    }

    public boolean getValidMove(){
        return this.validMove;
    }

    public void setValidMove(boolean validMove){
        this.validMove = validMove;
    }

    public int getKingCaptured(){
        return this.kingCaptured;
    }

    public void setKingCaptured(int kingCaptured){
        this.kingCaptured = kingCaptured;
    }

    public String getNextMove(){
        return this.nextMove;
    }

    public List<String> getMoveList(){
        return this.moveList;
    }

    public int getNumberOfMoves(){
        return this.numberOfMoves;
    }
}
