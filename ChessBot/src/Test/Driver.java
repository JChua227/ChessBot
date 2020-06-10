package Test;

import Decision.Bot;
import Decision.GenerateBoard;
import Decision.Move;
import Pieces.Piece;

import java.util.*;

public class Driver{
    public static void main(String []args){

        List<String> list = new ArrayList<>();
        Bot bot = new Bot();
        Move move = bot.getNextMove(list,7);

        bot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        double evaluation = move.getEvaluation();
        System.out.println("Evaluation: " + evaluation);
        System.out.println(move.getMoveList());
        System.out.println(move.getGameState()[2][2].getMoved() + " " + move.getGameState()[2][2].getPlayerPiece() + " " + move.getGameState()[2][2].toString());
    }

}