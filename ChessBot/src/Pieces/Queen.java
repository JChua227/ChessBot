package Pieces;

import java.util.*;

public class Queen extends Piece{

    public Queen(boolean playerPiece){
        super(playerPiece,100);
    }

    public String toString(){
        return getPlayerPiece() + "Queen";
    }

    public List<Piece[][]> getPossibleMoves(Piece [][]gameBoard, int x, int y){
        List<Piece[][]> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y+1;
        while(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder++;
            yHolder++;
            if(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y-1;
        while(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder--;
            yHolder--;
            if(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x+1;
        yHolder = y-1;
        while(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder++;
            yHolder--;
            if(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y+1;
        while(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder--;
            yHolder++;
            if(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x+1;
        yHolder = y;
        while(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder++;
            if(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y;
        while(xHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            xHolder--;
            if(xHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x;
        yHolder = y+1;
        while(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            yHolder++;
            if(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x;
        yHolder = y-1;
        while(yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            list.add(possiblePosition);
            yHolder--;
            if(yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                list.add(possibleTakePosition);
            }
        }

        return list;
    }
}