package Decision;

import Pieces.*;

import java.util.List;

public class GenerateBoard{

    public GenerateBoard(){

    }

    public Piece[][] create(){
        Piece [][]gameBoard = new Piece[8][8];
        fillPawn(gameBoard);
        fillRook(gameBoard);
        fillBishop(gameBoard);
        fillKnight(gameBoard);
        fillQueen(gameBoard);
        fillKing(gameBoard);
        return gameBoard;
    }

    public void fillPawn(Piece [][]gameBoard){
        for(int x=0; x<8; x++){
            gameBoard[6][x] = new Pawn(true);
            gameBoard[1][x] = new Pawn(false);
        }
    }

    public void fillRook(Piece [][]gameBoard){
        gameBoard[7][0] = new Rook(true);
        gameBoard[7][7] = new Rook(true);
        gameBoard[0][0] = new Rook(false);
        gameBoard[0][7] = new Rook(false);
    }

    public void fillBishop(Piece [][]gameBoard){
        gameBoard[7][2] = new Bishop(true);
        gameBoard[7][5] = new Bishop(true);
        gameBoard[0][2] = new Bishop(false);
        gameBoard[0][5] = new Bishop(false);
    }

    public void fillKnight(Piece[][]gameBoard){
        gameBoard[7][1] = new Knight(true);
        gameBoard[7][6] = new Knight(true);
        gameBoard[0][1] = new Knight(false);
        gameBoard[0][6] = new Knight(false);
    }

    public void fillQueen(Piece [][]gameBoard){
        gameBoard[7][3] = new Queen(true);
        gameBoard[0][3] = new Queen(false);
    }

    public void fillKing(Piece [][]gameBoard){
        gameBoard[7][4] = new King(true);
        gameBoard[0][4] = new King(false);
    }


    public void playMoves(List<String> notation){

    }


}