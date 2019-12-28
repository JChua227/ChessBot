package Test;

import Decision.GenerateBoard;
import Pieces.Piece;

import java.util.*;

public class Driver{
    public static void main(String []args){
        try{
            //creates game
            GenerateBoard gb = new GenerateBoard();
            Piece [][]temp = gb.create();
            printBoard(temp);

            //gets board value
            double boardValue = (double)sumStaticPosition(temp)/10;
            System.out.println(boardValue);

            //gets possible positions
            List<Piece[][]> list = new ArrayList<>();
            list = getAllPossiblePositions(temp,false);
            for(int x=0; x<list.size(); x++){
                printBoard(list.get(x));
                System.out.println("-----------------------------------------------------------------------------------------------------------");
            }
            System.out.println("List size: " + list.size());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<Piece[][]> getAllPossiblePositions(Piece[][]gameBoard,boolean player){
        List<Piece[][]> list = new ArrayList<>();
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y]!=null && player==gameBoard[x][y].getPlayerPiece()){
                    list.addAll(gameBoard[x][y].getPossibleMoves(gameBoard,x,y));
                }
            }
        }
        return list;
    }

    public static int sumStaticPosition(Piece [][]gameBoard){
        int pieceCountWorth = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Piece){
                    if(gameBoard[x][y].getPlayerPiece()){
                        pieceCountWorth += gameBoard[x][y].getPieceWorth();
                    }
                    else{
                        pieceCountWorth -= gameBoard[x][y].getPieceWorth();
                    }
                }
            }
        }
        return pieceCountWorth;
    }

    public static void printBoard(Piece[][]gameBoard){
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Piece){
                    System.out.print(gameBoard[x][y].toString());
                    for(int a=gameBoard[x][y].toString().length(); a<12; a++){
                        System.out.print(" ");
                    }
                }
                else{
                    System.out.print("     []     ");
                }
            }
            System.out.println();
        }
    }

}