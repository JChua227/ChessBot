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


        //bot plays against itself
        /*double evaluation = 0;
        while(evaluation!=1000000000 || evaluation!=-1000000000){
            Bot tempBot = new Bot();
            Move tempMove = tempBot.getNextMove(list,0);
            tempBot.printBoard(tempMove.getGameState());
            System.out.println("----------------------------------------------------------------------------------------------");
            Bot bot = new Bot();
            Move move = bot.getNextMove(list,4);
            list.add(move.getNextMove());
            System.out.println(move.getNextMove() + " " + evaluation);
            evaluation = move.getEvaluation();
        }*/

        //shows list of moves it believes are best in order from given depth
        /*List<String> unallowedMoves = new ArrayList<>();
        double evaluation = 0;
        while(evaluation<1000000000 || evaluation>-1000000000){
            List<String> tempList = new ArrayList<>(list);
            Bot bot = new Bot(unallowedMoves);
            Move move = bot.getNextMove(list,5);
            list = new ArrayList<>(tempList);
            System.out.println(move.getNextMove() + " " + evaluation);
            unallowedMoves.add(move.getNextMove());
            evaluation = move.getEvaluation();
        }*/

        //finds next best move
        /*Bot bot = new Bot();
        Move move = bot.getNextMove(list,0);
        bot.printBoard(move.getGameState());
        System.out.println("----------------------------------------------------------------------------------------------");
        Bot futureBot = new Bot();
        move = futureBot.getNextMove(list,4);
        futureBot.printBoard(move.getGameState());
        System.out.println(move.getNextMove());
        double evaluation = move.getEvaluation();
        System.out.println("Evaluation: " + evaluation);
        System.out.println(move.getMoveList());*/
    }

}