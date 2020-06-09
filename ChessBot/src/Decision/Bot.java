package Decision;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    private Evaluator evaluator;
    private GenerateBoard generateBoard = new GenerateBoard();
    private int depth;

    public Bot(){
        evaluator = new Evaluator();
        generateBoard.create();
    }

    public Move getNextMove(List<String> notation,int depth){
        this.depth = depth;

        boolean turn = false;
        if(notation.size()%2==0){
            turn = true;
        }

        Move move = new Move(this.generateBoard.getGameBoard(),0,"", notation);
        this.generateBoard.playMoves(notation);

        if(this.evaluator.gameIsFinished(move)){
            if(evaluator.checkWinner(move)){
                return new Move(move.getGameState(),1000000000,"White won!");
            }
            else{
                return new Move(move.getGameState(),-1000000000,"Black won!");
            }
        }
        else if(evaluator.checkTie(move.getGameState())){
            return new Move(move.getGameState(),0,"Its a tie!");
        }

        return miniMax(move, depth, turn, -2000000000, 2000000000, "");
    }


    public Move miniMax(Move move, int depth, boolean turn, double alpha, double beta, String moveNotation){

        if(evaluator.gameIsFinished(move)){
            if(evaluator.checkWinner(move)){
                return new Move(move.getGameState(),1000000000,moveNotation,move.getMoveList());
            }
            else{
                return new Move(move.getGameState(),-1000000000,moveNotation,move.getMoveList());
            }
        }
        else if(evaluator.checkTie(move.getGameState())){
            return new Move(move.getGameState(),0,moveNotation,move.getMoveList());
        }
        else if(depth==0){
            return evaluator.evaluatePosition(move,moveNotation);
        }

        List<Move> states = getAllPossiblePositions(move.getGameState(),turn,move.getMoveList());
        if(turn){
            Move maxEval = new Move(move.getGameState(),-2000000000,"");
            for(int x=0; x<states.size(); x++){
                if(depth==this.depth){
                    moveNotation = states.get(x).getMoveList().get(states.get(x).getMoveList().size()-1);
                }
                Move evaluation = miniMax(states.get(x),depth-1+states.get(x).getExtraTakePieceDepth(),!turn,alpha,beta,moveNotation);
                if(maxEval.getEvaluation()<evaluation.getEvaluation()){
                    maxEval = evaluation;
                }
                if(alpha<evaluation.getEvaluation()){
                    alpha = evaluation.getEvaluation();
                }
                if(alpha >= beta){
                    break;
                }
            }
            return maxEval;
        }
        else{
            Move minEval = new Move(move.getGameState(),2000000000,"");
            for(int x=0; x<states.size(); x++){
                if(depth==this.depth){
                    moveNotation = states.get(x).getMoveList().get(states.get(x).getMoveList().size()-1);
                }
                Move evaluation = miniMax(states.get(x),depth-1+states.get(x).getExtraTakePieceDepth(),!turn,alpha,beta,moveNotation);
                if(minEval.getEvaluation()>evaluation.getEvaluation()){
                    minEval = evaluation;
                }
                if(beta>evaluation.getEvaluation()){
                    beta = evaluation.getEvaluation();
                }
                if(alpha >= beta){
                    break;
                }
            }
            return minEval;
        }

    }


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

    public static void printBoard(Piece[][]gameBoard){
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Piece){
                    System.out.print(gameBoard[x][y].toString());

                    //12 = this is the longest toString length + 1, (falseKnight + 1)
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
