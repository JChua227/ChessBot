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

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        List<Move> list = new ArrayList<>();

        int xHolder = x+1;
        int yHolder = y;
        while(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            rook.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            xHolder++;
            if(xHolder!=gameBoard.length && gameBoard[xHolder][yHolder]!=null && gameBoard[xHolder][yHolder].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                rookTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation2);
                list.add(take);
            }
        }

        xHolder = x-1;
        yHolder = y;
        while(xHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            rook.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            xHolder--;
            if(xHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                rookTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation2);
                list.add(take);
            }
        }

        xHolder = x;
        yHolder = y+1;
        while(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            rook.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            yHolder++;
            if(yHolder!=gameBoard[0].length && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                rookTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation2);
                list.add(take);
            }
        }

        xHolder = x;
        yHolder = y-1;
        while(yHolder!=-1 && gameBoard[xHolder][yHolder]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
            rook.setMoved();
            possiblePosition[x][y] = null;
            possiblePosition[xHolder][yHolder] = rook;
            List<String> newNotation = this.generateNewNotation(notation, x, y, xHolder, yHolder);
            Move move = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation);
            list.add(move);
            yHolder--;
            if(yHolder!=-1 && gameBoard[xHolder][yHolder]!=null && !gameBoard[xHolder][yHolder].getPlayerPiece()){
                Piece[][] possibleTakePosition = this.copy(gameBoard);
                Rook rookTake = new Rook(gameBoard[x][y].getPlayerPiece());
                rookTake.setMoved();
                possibleTakePosition[x][y] = null;
                possibleTakePosition[xHolder][yHolder] = rookTake;
                List<String> newNotation2 = this.generateNewNotation(notation, x, y, xHolder, yHolder);
                Move take = new Move(x, y, xHolder, yHolder, possiblePosition, newNotation2);
                list.add(take);
            }
        }
        return list;
    }
}