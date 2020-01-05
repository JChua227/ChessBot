package Decision;

import Pieces.Piece;

public class Move {

    private int xSelectedPosition;
    private int ySelectedPosition;
    private int xLandedPosition;
    private int yLandedPosition;
    private Piece[][] gameState;
    private int depth;
    private int extraTakePieceDepth = 0;
    private int evaluation;

    public Move(int xSelectedPosition, int ySelectedPosition, int xLandedPosition, int yLandedPosition, Piece[][] gameState, int depth, int evaluation){
        this.xSelectedPosition = xSelectedPosition;
        this.ySelectedPosition = ySelectedPosition;
        this.xLandedPosition = xLandedPosition;
        this.yLandedPosition = yLandedPosition;
        this.gameState = gameState;
        this.depth = depth;
        this.evaluation = evaluation;
    }

    public int getXSelectedPosition(){
        return this.xSelectedPosition;
    }

    public int getYSelectedPosition(){
        return this.ySelectedPosition;
    }

    public int getXLandedPosition(){
        return this.xLandedPosition;
    }

    public int getYLandedPosition(){
        return this.yLandedPosition;
    }

    public Piece[][] getGameState(){
        return this.gameState;
    }

    public int getDepth(){
        return this.depth + this.extraTakePieceDepth;
    }

    public int getEvaluation(){
        return this.evaluation;
    }

    public void incrementTakePieceDepth(){
        this.extraTakePieceDepth++;
    }
}
