package Pieces;

import Decision.Move;

import java.util.*;

public class Queen extends Piece{

    public Queen(boolean playerPiece){
        super(playerPiece,100);
    }

    public String toString(){
        return getPlayerPiece() + "Queen";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        List<Move> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y+1;
        while(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder++;
            yHolder++;
            if(xHolder!=gameBoard.length && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y-1;
        while(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder--;
            yHolder--;
            if(xHolder!=-1 && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x+1;
        yHolder = y-1;
        while(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder++;
            yHolder--;
            if(xHolder!=gameBoard.length && yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y+1;
        while(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder--;
            yHolder++;
            if(xHolder!=-1 && yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x+1;
        yHolder = y;
        while(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder++;
            if(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y;
        while(xHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            xHolder--;
            if(xHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x;
        yHolder = y+1;
        while(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            yHolder++;
            if(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        xHolder = x;
        yHolder = y-1;
        while(yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
            queen.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = queen;
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition);
            list.add(move);
            yHolder--;
            if(yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Queen queenTake = new Queen(gameBoard[x][y].getPlayerPiece());
                queenTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = queenTake;
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition);
                list.add(take);
            }
        }

        return list;
    }
}