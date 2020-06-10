package Pieces;

import Decision.Move;

import java.util.*;

public class Pawn extends Piece{

    public Pawn(boolean playerPiece){
        super(playerPiece,100);
    }

    public String toString(){
        return getPlayerPiece() + "Pawn";
    }

    //TODO: get all possible moves for pawns
    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation){
        int forward = -1;
        if(!gameBoard[x][y].getPlayerPiece()){
            forward = 1;
        }

        List<Move> list = new ArrayList<>();

        if(gameBoard[x+forward][y]==null){
            if(x+forward==gameBoard.length-1 || x+forward==0){
                pawnPromotion(gameBoard,x,y,notation,list,forward,0);
            }
            else {
                Piece[][] possiblePosition = this.copy(gameBoard);
                Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
                pawn.setMoved(true);
                possiblePosition[x][y] = null;
                possiblePosition[x + forward][y] = pawn;
                List<String> newNotation = this.generateNewNotation(notation, x, y, x + forward, y);
                Move move = new Move(x, y, x + forward, y, possiblePosition, newNotation);
                list.add(move);
            }
        }

        if(!gameBoard[x][y].getMoved() && gameBoard[x+forward][y]==null && gameBoard[x+forward+forward][y]==null){
            Piece[][] possiblePosition = this.copy(gameBoard);
            Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
            pawn.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+forward+forward][y] = pawn;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+forward+forward, y);
            Move move = new Move(x, y, x+forward+forward, y, possiblePosition, newNotation);
            list.add(move);
        }

        if(y-1>-1 && gameBoard[x+forward][y-1]!=null && gameBoard[x][y].getPlayerPiece()!=gameBoard[x+forward][y-1].getPlayerPiece()){
            if(x+forward==gameBoard.length-1 || x+forward==0){
                pawnPromotion(gameBoard,x,y,notation,list,forward,-1);
            }
            else {
                Piece[][] possiblePosition = this.copy(gameBoard);
                Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
                pawn.setMoved(true);
                possiblePosition[x][y] = null;
                possiblePosition[x + forward][y - 1] = pawn;
                List<String> newNotation = this.generateNewNotation(notation, x, y, x + forward, y - 1);
                Move move = new Move(x, y, x + forward, y - 1, possiblePosition, newNotation);
                list.add(move);
            }
        }

        if(y+1<gameBoard[0].length && gameBoard[x+forward][y+1]!=null && gameBoard[x][y].getPlayerPiece()!=gameBoard[x+forward][y+1].getPlayerPiece()){
            if(x+forward==gameBoard.length-1 || x+forward==0){
                pawnPromotion(gameBoard,x,y,notation,list,forward,1);
            }
            else {
                Piece[][] possiblePosition = this.copy(gameBoard);
                Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
                pawn.setMoved(true);
                possiblePosition[x][y] = null;
                possiblePosition[x + forward][y + 1] = pawn;
                List<String> newNotation = this.generateNewNotation(notation, x, y, x + forward, y + 1);
                Move move = new Move(x, y, x + forward, y + 1, possiblePosition, newNotation);
                list.add(move);
            }
        }

        return list;
    }

    public void pawnPromotion(Piece [][]gameBoard, int x, int y, List<String> notation,List<Move> list,int forward,int yIncrementer){
        Piece[][] possiblePosition1 = this.copy(gameBoard);
        Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
        queen.setMoved(true);
        possiblePosition1[x][y] = null;
        possiblePosition1[x + forward][y+yIncrementer] = queen;
        List<String> newNotation1 = this.generateNewNotation(notation, x, y, x + forward, y+yIncrementer);
        Move move1 = new Move(x, y, x + forward, y+yIncrementer, possiblePosition1, newNotation1);
        list.add(move1);

        Piece[][] possiblePosition2 = this.copy(gameBoard);
        Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
        rook.setMoved(true);
        possiblePosition2[x][y] = null;
        possiblePosition2[x + forward][y+yIncrementer] = rook;
        List<String> newNotation2 = this.generateNewNotation(notation, x, y, x + forward, y+yIncrementer);
        Move move2 = new Move(x, y, x + forward, y+yIncrementer, possiblePosition2, newNotation2);
        list.add(move2);

        Piece[][] possiblePosition3 = this.copy(gameBoard);
        Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
        knight.setMoved(true);
        possiblePosition3[x][y] = null;
        possiblePosition3[x + forward][y+yIncrementer] = knight;
        List<String> newNotation3 = this.generateNewNotation(notation, x, y, x + forward, y+yIncrementer);
        Move move3 = new Move(x, y, x + forward, y+yIncrementer, possiblePosition3, newNotation3);
        list.add(move3);

        Piece[][] possiblePosition4 = this.copy(gameBoard);
        Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
        bishop.setMoved(true);
        possiblePosition4[x][y] = null;
        possiblePosition4[x + forward][y+yIncrementer] = bishop;
        List<String> newNotation4 = this.generateNewNotation(notation, x, y, x + forward, y+yIncrementer);
        Move move4 = new Move(x, y, x + forward, y+yIncrementer, possiblePosition4, newNotation4);
        list.add(move4);
    }

}