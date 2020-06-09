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

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){

        List<Move> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y+1;
        while(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            bishop.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation);
            list.add(move);
            xHolder++;
            yHolder++;
            if(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                bishopTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation2);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y-1;
        while(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            bishop.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation);
            list.add(move);
            xHolder--;
            yHolder--;
            if(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                bishopTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation2);
                list.add(take);
            }
        }

        xHolder = x+1;
        yHolder = y-1;
        while(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            bishop.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            xHolder++;
            yHolder--;
            if(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                bishopTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation2);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y+1;
        while(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
            bishop.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = bishop;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            xHolder--;
            yHolder++;
            if(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Bishop bishopTake = new Bishop(gameBoard[x][y].getPlayerPiece());
                bishopTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = bishopTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition,newNotation2);
                list.add(take);
            }
        }
        return list;
    }
}