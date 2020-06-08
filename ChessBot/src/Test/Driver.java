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
        Move move = bot.getNextMove(list,4);

        bot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        System.out.println("Evaluation: " + move.getEvaluation());
        System.out.println(move.getMoveList());

    }

}