package Decision;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    private Evaluator evaluator;
    private GenerateBoard generateBoard = new GenerateBoard();

    public Bot(){
        evaluator = new Evaluator();
        generateBoard.create();
    }

    /*public Move getNextMove(List<String> notation){
        generateBoard.playMoves(notation);
        return miniMax();
    }*/


    /*public Move miniMax(Move move, int depth, boolean turn, int alpha, int beta, int childX, int childY){
        int player = 1;
        if(!turn){
            player = 2;
        }

        if(evaluator.gameIsFinished(move)){
            if(evaluator.checkWinner(move)){
                return new Move(move.getGameState(),100000,childX,childY);
            }
            else{
                return new Move(move.getGameState(),-100000,childX,childY);
            }
        }
        else if(checkTie(move.getGameState())){
            return new Move(move.getGameState(),0,childX,childY,0);
        }
        else if(depth==0){
            return evaluatePosition(move,childX,childY);
        }

        List<Move> states = getAllPossiblePositions(move.getGameState(),turn);

        if(turn){
            Move maxEval = new Move(move.getGameState(),-999999999);
            for(int x=0; x<states.size(); x++){
                if(depth==this.depth){
                    childX = states.get(x).getX();
                    childY = states.get(x).getY();
                }
                Move evaluation = miniMax(states.get(x),depth-1,!turn,alpha,beta,childX,childY);
                if(maxEval.getRating()<evaluation.getRating()){
                    maxEval = evaluation;
                }
                if(alpha<evaluation.getRating()){
                    alpha = evaluation.getRating();
                }
                if(alpha >= beta){
                    break;
                }
            }
            return maxEval;
        }
        else{
            Move minEval = new Move(move.getGameState(),999999999);
            for(int x=0; x<states.size(); x++){
                if(depth==this.depth){
                    childX = states.get(x).getX();
                    childY = states.get(x).getY();
                }
                Move evaluation = miniMax(states.get(x),depth-1,!turn,alpha,beta,childX,childY);
                if(minEval.getRating()>evaluation.getRating()){
                    minEval = evaluation;
                }
                if(beta>evaluation.getRating()){
                    beta = evaluation.getRating();
                }
                if(alpha >= beta){
                    break;
                }
            }
            return minEval;
        }

    }*/


    public static List<Move> getAllPossiblePositions(Piece[][]gameBoard,boolean player,List<String> notation){
        List<Move> list = new ArrayList<>();
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y]!=null && player==gameBoard[x][y].getPlayerPiece()){
                    list.addAll(gameBoard[x][y].getPossibleMoves(gameBoard, x, y, notation));
                }
            }
        }
        return list;
    }

}
