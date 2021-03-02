package Pieces;

import Decision.Move;

import java.util.*;

public class Bishop extends Piece{

    public Bishop(boolean playerPiece){
        super(playerPiece,330);
    }

    public String toString(){
        return getPlayerPiece() + "Bishop";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation, boolean validMoveChecker){

        List<Move> list = new ArrayList<>();

        possibleBishopMoves(list,x+1,y+1,x,y,1,1,gameBoard,notation);
        possibleBishopMoves(list,x-1,y-1,x,y,-1,-1,gameBoard,notation);
        possibleBishopMoves(list,x+1,y-1,x,y,1,-1,gameBoard,notation);
        possibleBishopMoves(list,x-1,y+1,x,y,-1,1,gameBoard,notation);

        return list;
    }

    public void possibleBishopMoves(List<Move> list,int xHolder,int yHolder,int x, int y,int xIncrement, int yIncrement,Piece [][]gameBoard,List<String> notation){

        while(xHolder!=gameBoard.length && xHolder!=-1 && yHolder!=gameBoard[0].length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            bishop.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation);
            list.add(move);
            xHolder+=xIncrement;
            yHolder+=yIncrement;
            if(xHolder!=gameBoard.length && xHolder!=-1 && yHolder!=gameBoard[0].length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                bishopTake.setMoved(true);
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possibleTakePosition,newNotation2);
                take.setKingCaptured(isEnemyKing(gameBoard,xHolder,yHolder));
                list.add(take);
            }
        }

    }
}