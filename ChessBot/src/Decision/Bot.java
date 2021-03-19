package Decision;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bot {

    private Evaluator evaluator;
    private GenerateBoard generateBoard = new GenerateBoard();
    private int depth;
    private List<String> unallowedMoves = new ArrayList<>();

    public Bot(List<String> unallowedMoves){
        evaluator = new Evaluator();
        this.generateBoard.create();
        this.unallowedMoves = unallowedMoves;
    }

    public Bot(){
        evaluator = new Evaluator();
        this.generateBoard.create();
    }

    public Move getNextMove(List<String> notation,int depth){
        this.depth = depth;

        boolean turn = false;
        if(notation.size()%2==0){
            turn = true;
        }

        Move move = new Move(this.generateBoard.getGameBoard(),0,"", notation);
        this.generateBoard.playMoves(notation);

        if(move.getKingCaptured()!=0){
            if(move.getKingCaptured()==1){
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

        if(evaluator.checkTie(move.getGameState())){
            return new Move(move.getGameState(),0,moveNotation,move.getMoveList());
        }
        else if(depth==0){
            return evaluator.evaluatePosition(move,moveNotation);
        }

        List<Move> states = getAllPossiblePositions(move.getGameState(),turn,move.getMoveList(),true);
        filterPossibleMoves(states,turn);
        if(this.depth==depth){
            if(!unallowedMoves.isEmpty()){
                filterUnallowedMoves(states,unallowedMoves);
            }
        }


        //visually seeing all positions generated
        /*for(int x=0; x<states.size(); x++){
            printBoard(states.get(x).getGameState());
            System.out.println(states.get(x).getMoveList().get(states.get(x).getMoveList().size()-1));
            System.out.println(states.get(x).getMoveList());
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }*/

        if(states.size()==0) {
            List<Move> possibleCheckMate = getAllPossiblePositions(move.getGameState(),!turn,move.getMoveList(),true);
            if(isCheckMate(possibleCheckMate)){
                if(turn){
                    return new Move(move.getGameState(),-1000000000-depth,moveNotation,move.getMoveList());
                }
                else{
                    return new Move(move.getGameState(),1000000000+depth,moveNotation,move.getMoveList());
                }
            }
            return new Move(move.getGameState(), 0, moveNotation, move.getMoveList());
        }

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

    public void filterUnallowedMoves(List<Move> states, List<String> unallowedMoves){
        for(int x=0; x<unallowedMoves.size(); x++){
            for(int y=0; y<states.size(); y++){
                if(states.get(y).getMoveList().get(states.get(y).getMoveList().size()-1).equals(unallowedMoves.get(x))){
                    states.remove(y);
                    y=states.size();
                }
            }
        }
    }


    public boolean isCheckMate(List<Move> possibleCheckMate){
        for(int x=0; x<possibleCheckMate.size(); x++){
            if(possibleCheckMate.get(x).getKingCaptured()!=0){
                return true;
            }
        }
        return false;
    }

    public void filterPossibleMoves(List<Move> states,boolean turn){
        for(int x=0; x<states.size(); x++) {
            if (!checkLegalMove(states.get(x).getGameState(), turn, states.get(x).getMoveList().get(states.get(x).getMoveList().size()-1))) {
                states.remove(x);
                x--;
            }
        }
    }

    public boolean checkLegalMove(Piece[][] gameBoard,boolean player, String s){
        List<String> notation = Arrays.asList(s);
        List<Move> nextPossibleMoves = getAllPossiblePositions(gameBoard,!player,notation,false);
        for(int a=0; a<nextPossibleMoves.size(); a++){
            if(player && nextPossibleMoves.get(a).getKingCaptured()==-1){
                return false;
            }
            else if(!player && nextPossibleMoves.get(a).getKingCaptured()==1){
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

    public void printBoard(Piece[][]gameBoard){
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
