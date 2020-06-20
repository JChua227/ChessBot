/*Example Notation: e2-e4 to move/take a piece and e7-e8=Q for pawn promotion into a queen*/

package Test;

import Decision.Bot;
import Decision.GenerateBoard;
import Decision.Move;
import Pieces.Piece;

import java.util.*;

public class Driver{
    public static void main(String []args){

        List<String> list = new ArrayList<>();

        list.add("e2-e4");
        list.add("f1-c4");
        list.add("a7-a6");
        list.add("d1-f3");
        list.add("f3-f7");
        list.add("e8-f7");



        Bot bot = new Bot();
        Move move = bot.getNextMove(list,1);

        bot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        double evaluation = move.getEvaluation();
        System.out.println("Evaluation: " + evaluation);
        System.out.println(move.getMoveList());
    }

}