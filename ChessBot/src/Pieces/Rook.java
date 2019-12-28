package Pieces;

import java.util.*;

public class Rook extends Piece{

    public Rook(boolean playerPiece){
        super(playerPiece,50);
    }

    public String toString(){
        return getPlayerPiece() + "Rook";
    }

    public List<Piece[][]> getPossibleMoves(Piece [][]gameBoard, int x, int y){
        List<Piece[][]> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y;
        while(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            list.add(possiblePosition);
            xHolder++;
            if(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x-1;
        yHolder = y;
        while(xHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            list.add(possiblePosition);
            xHolder--;
            if(xHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x;
        yHolder = y+1;
        while(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            list.add(possiblePosition);
            yHolder++;
            if(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                list.add(possibleTakePosition);
            }
        }

        xHolder = x;
        yHolder = y-1;
        while(yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            list.add(possiblePosition);
            yHolder--;
            if(yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                list.add(possibleTakePosition);
            }
        }
        return list;
    }
}