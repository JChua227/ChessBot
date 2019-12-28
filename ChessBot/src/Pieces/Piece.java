package Pieces;

import java.util.*;

public abstract class Piece{

    private boolean playerPiece;
    private int pieceWorth;

    public Piece(boolean playerPiece,int pieceWorth){
        this.playerPiece = playerPiece;
        this.pieceWorth = pieceWorth;
    }

    public boolean getPlayerPiece(){
        return this.playerPiece;
    }

    public int getPieceWorth(){
        return this.pieceWorth;
    }

    public Piece[][] copy(Piece [][]gameBoard){
        Piece[][] temp = new Piece[8][8];
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Pawn){
                    Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = pawn;
                }
                else if(gameBoard[x][y] instanceof Bishop){
                    Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = bishop;
                }
                else if(gameBoard[x][y] instanceof Rook){
                    Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = rook;
                }
                else if(gameBoard[x][y] instanceof Knight){
                    Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = knight;
                }
                else if(gameBoard[x][y] instanceof Queen){
                    Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = queen;
                }
                else if(gameBoard[x][y] instanceof King){
                    King king = new King(gameBoard[x][y].getPlayerPiece());
                    temp[x][y] = king;
                }
            }
        }
        return temp;
    }

    public abstract List<Piece[][]> getPossibleMoves(Piece[][] gameBoard, int x, int y);
}
