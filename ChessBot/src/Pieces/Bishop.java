package Pieces;

import java.util.*;

public class Bishop extends Piece{

    public Bishop(boolean playerPiece){
        super(playerPiece,33);
    }

    public String toString(){
        return getPlayerPiece() + "Bishop";
    }

    public List<Piece[][]> getPossibleMoves(Piece [][]gameBoard, int x, int y){
        List<Piece[][]> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y+1;
        while(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            list.add(possiblePosition);
            xHolder++;
            yHolder++;
            if(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y-1;
        while(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            list.add(possiblePosition);
            xHolder--;
            yHolder--;
            if(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x+1;
        yHolder = y-1;
        while(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            list.add(possiblePosition);
            xHolder++;
            yHolder--;
            if(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y+1;
        while(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            list.add(possiblePosition);
            xHolder--;
            yHolder++;
            if(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                list.add(possibleTakePosition);
            }
        }
        return list;
    }
}