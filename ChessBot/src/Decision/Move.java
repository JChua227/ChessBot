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
    private int depth;
    private int extraTakePieceDepth = 0;
    private int evaluation;
    private List<String> moveList;

    public Move(int xSelectedPosition, int ySelectedPosition, int xLandedPosition, int yLandedPosition, Piece[][] gameState, int depth, int evaluation){
        this.xSelectedPosition = xSelectedPosition;
        this.ySelectedPosition = ySelectedPosition;
        this.xLandedPosition = xLandedPosition;
        this.yLandedPosition = yLandedPosition;
        this.gameState = gameState;
        this.depth = depth;
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

    public Move(Piece[][] gameState, int evaluation){
        this.gameState = gameState;
        this.evaluation = evaluation;
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

    public int getDepth(){
        return this.depth + this.extraTakePieceDepth;
    }

    public void incrementTakePieceDepth(){
        this.extraTakePieceDepth++;
    }

    public int getEvaluation(){
        return this.evaluation;
    }

    public void setMoveList(String s){
        this.moveList.add(s);
    }

    public List<String> getMoveList(){
        return this.moveList;
    }
}
