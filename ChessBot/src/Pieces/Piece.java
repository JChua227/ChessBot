package Pieces;

import Decision.Move;
import Decision.NotationConverter;

import java.util.*;

public abstract class Piece{

    private boolean playerPiece;
    private int pieceWorth;
    private boolean moved = false;
    private static NotationConverter notationConverter = new NotationConverter();

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

    public boolean getMoved(){
        return this.moved;
    }

    public void setMoved(boolean moved){
        this.moved = moved;
    }

    public NotationConverter getNotationConverter(){
        return this.notationConverter;
    }

    public Piece[][] copy(Piece [][]gameBoard){
        Piece[][] temp = new Piece[8][8];
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Pawn){
                    Pawn pawn = new Pawn(gameBoard[x][y].getPlayerPiece());
                    pawn.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = pawn;
                }
                else if(gameBoard[x][y] instanceof Bishop){
                    Bishop bishop = new Bishop(gameBoard[x][y].getPlayerPiece());
                    bishop.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = bishop;
                }
                else if(gameBoard[x][y] instanceof Rook){
                    Rook rook = new Rook(gameBoard[x][y].getPlayerPiece());
                    rook.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = rook;
                }
                else if(gameBoard[x][y] instanceof Knight){
                    Knight knight = new Knight(gameBoard[x][y].getPlayerPiece());
                    knight.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = knight;
                }
                else if(gameBoard[x][y] instanceof Queen){
                    Queen queen = new Queen(gameBoard[x][y].getPlayerPiece());
                    queen.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = queen;
                }
                else if(gameBoard[x][y] instanceof King){
                    King king = new King(gameBoard[x][y].getPlayerPiece());
                    king.setMoved(gameBoard[x][y].getMoved());
                    temp[x][y] = king;
                }
            }
        }
        return temp;
    }

    public abstract List<Move> getPossibleMoves(Piece[][] gameBoard, int x, int y,List<String> notation,boolean validMoveChecker);

    //generates new notation
    public List<String> generateNewNotation(List<String> notation, int x, int y, int xDestination, int yDestination){
        List<String> list = new ArrayList<>();
        list.addAll(notation);
        list.add(getNotationConverter().getNotationColumn(y) + "" + getNotationConverter().getNotationRow(x) + "-" + getNotationConverter().getNotationColumn(yDestination) + getNotationConverter().getNotationRow(xDestination));
        return list;
    }

    //generates new notation with pawn promotion
    public List<String> generateNewNotation(List<String> notation, int x, int y, int xDestination, int yDestination,String s){
        List<String> list = new ArrayList<>();
        list.addAll(notation);
        list.add(getNotation(x,y,xDestination,yDestination,s));
        return list;
    }

    public String getNotation(int x, int y, int xDestination, int yDestination, String s){
        return getNotationConverter().getNotationColumn(y) + "" + getNotationConverter().getNotationRow(x) + "-" + getNotationConverter().getNotationColumn(yDestination) + getNotationConverter().getNotationRow(xDestination) + s;
    }

    public int isEnemyKing(Piece[][] gameBoard, int xHolder, int yHolder){
        if(gameBoard[xHolder][yHolder] instanceof King){
            if(gameBoard[xHolder][yHolder].getPlayerPiece()){
                return -1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }

    public boolean checkLegalMove(Piece[][] gameBoard,boolean player, String s){
        List<String> notation = Arrays.asList(s);
        List<Move> nextPossibleMoves = getAllPossiblePositions(gameBoard,!player,notation,false);
        for(int a=0; a<nextPossibleMoves.size(); a++){
            if(nextPossibleMoves.get(a).getKingCaptured()!=0){
                return false;
            }
        }
        return true;
    }

    public List<Move> getAllPossiblePositions(Piece[][]gameBoard,boolean player,List<String> notation,boolean validMoveChecker){
        List<Move> list = new ArrayList<>();
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y]!=null && player==gameBoard[x][y].getPlayerPiece()){
                    list.addAll(gameBoard[x][y].getPossibleMoves(gameBoard, x, y, notation,validMoveChecker));
                }
            }
        }
        return list;
    }
}
