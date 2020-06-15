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
        list.add("a2-a3");
        list.add("g7-g5");


        Bot bot = new Bot();
        Move move = bot.getNextMove(list,2);

        bot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        double evaluation = move.getEvaluation();
        System.out.println("Evaluation: " + evaluation);
        System.out.println(move.getMoveList());
    }

}