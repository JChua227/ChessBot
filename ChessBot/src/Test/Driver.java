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
        Move move = bot.getNextMove(list,1);

        bot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        double evaluation = move.getEvaluation();
        System.out.println("Evaluation: " + evaluation);
        System.out.println(move.getMoveList());
    }

}