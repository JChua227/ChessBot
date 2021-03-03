package Pieces;

import Decision.Move;

import java.util.*;

public class Rook extends Piece{

    public Rook(boolean playerPiece){
        super(playerPiece,500);
    }

    public String toString(){
        return getPlayerPiece() + "Rook";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation, boolean validMoveChecker){
        List<Move> list = new ArrayList<>();

        possibleQueenMoves(list,x+1,y,x,y,1,0,gameBoard,notation);
        possibleQueenMoves(list,x-1,y,x,y,-1,0,gameBoard,notation);
        possibleQueenMoves(list,x,y+1,x,y,0,1,gameBoard,notation);
        possibleQueenMoves(list,x,y-1,x,y,0,-1,gameBoard,notation);

        return list;
    }


    public void possibleQueenMoves(List<Move> list,int xHolder,int yHolder,int x, int y,int xIncrement, int yIncrement,Piece [][]gameBoard,List<String> notation){
        boolean enemyPieceAdjacent = true;
        while(xHolder!=gameBoard.length && xHolder!=-1 && yHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            enemyPieceAdjacent = false;
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            rook.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);

            xHolder+=xIncrement;
            yHolder+=yIncrement;

            possibleRookTake(list,xHolder,yHolder,x,y,gameBoard,notation);

        }

        if(enemyPieceAdjacent) {
            possibleRookTake(list, xHolder, yHolder, x, y, gameBoard, notation);
        }
    }

    public void possibleRookTake(List<Move> list,int xHolder,int yHolder,int x, int y,Piece [][]gameBoard,List<String> notation){
        if(xHolder!=gameBoard.length && xHolder!=-1 && yHolder!=gameBoard[0].length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
            Piece[][] possibleTakePosition = this.copy(gameBoard);
            Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
            rookTake.setMoved(true);
            possibleTakePosition[x][y] = null;
            possibleTakePosition[xHolder][yHolder] = rookTake;
            List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move take = new Move(x, y, xHolder, yHolder, possibleTakePosition, newNotation2);
            take.setKingCaptured(isEnemyKing(gameBoard,xHolder,yHolder));
            list.add(take);
        }
    }
}