package Decision;

import Pieces.*;

import java.util.List;

public class GenerateBoard{

    private Piece[][] gameBoard;
    private static NotationConverter notationConverter = new NotationConverter();
    private List<String> notation;

    public GenerateBoard(){

    }

    public NotationConverter getNotationConverter(){
        return this.notationConverter;
    }

    public void create(){
        Piece [][]gameBoard = new Piece[8][8];
        fillPawn(gameBoard);
        fillRook(gameBoard);
        fillBishop(gameBoard);
        fillKnight(gameBoard);
        fillQueen(gameBoard);
        fillKing(gameBoard);
        this.gameBoard = gameBoard;
    }

    public Piece[][] getGameBoard(){
        return this.gameBoard;
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


    //TODO: add notation to read pawn promotions and en passant
    public void playMoves(List<String> notation){
        this.notation = notation;

        for(int x=0; x<notation.size(); x++){
            int xPosition = getNotationConverter().getNotationRow().indexOf(Integer.parseInt(String.valueOf(notation.get(x).charAt(1))));
            int yPosition = getNotationConverter().getNotationColumn().indexOf(notation.get(x).charAt(0));
            int xEndPosition = getNotationConverter().getNotationRow().indexOf(Integer.parseInt(String.valueOf(notation.get(x).charAt(4))));
            int yEndPosition = getNotationConverter().getNotationColumn().indexOf(notation.get(x).charAt(3));

            if(getGameBoard()[xPosition][yPosition] instanceof Pawn){
                Pawn pawn = new Pawn(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = pawn;
            }
            else if(getGameBoard()[xPosition][yPosition] instanceof Rook){
                Rook rook = new Rook(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = rook;
            }
            else if(getGameBoard()[xPosition][yPosition] instanceof Bishop){
                Bishop bishop = new Bishop(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = bishop;
            }
            else if(getGameBoard()[xPosition][yPosition] instanceof Knight){
                Knight knight = new Knight(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = knight;
            }
            else if(getGameBoard()[xPosition][yPosition] instanceof Queen){
                Queen queen = new Queen(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = queen;
            }
            else if(getGameBoard()[xPosition][yPosition] instanceof King){
                King king = new King(getGameBoard()[xPosition][yPosition].getPlayerPiece());
                getGameBoard()[xEndPosition][yEndPosition] = king;
            }
            else{
                System.out.println("Error: accessing null piece in user move list");
            }
            getGameBoard()[xPosition][yPosition] = null;
        }
    }


}