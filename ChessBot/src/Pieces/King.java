package Pieces;

import Decision.Move;

import java.util.*;

public class King extends Piece{

    public King(boolean playerPiece){
        super(playerPiece,0);
    }

    public String toString(){
        return getPlayerPiece() + "King";
    }

    public List<Move> getPossibleMoves(Piece [][]gameBoard, int x, int y, List<String> notation, boolean validMoveChecker){

        List<Move> list = new ArrayList<>();

        possibleKingMoves(list,x,y,1,1,gameBoard,notation);
        possibleKingMoves(list,x,y,1,0,gameBoard,notation);
        possibleKingMoves(list,x,y,1,-1,gameBoard,notation);
        possibleKingMoves(list,x,y,0,-1,gameBoard,notation);
        possibleKingMoves(list,x,y,-1,-1,gameBoard,notation);
        possibleKingMoves(list,x,y,-1,0,gameBoard,notation);
        possibleKingMoves(list,x,y,-1,1,gameBoard,notation);
        possibleKingMoves(list,x,y,0,1,gameBoard,notation);

        //castle
        if(!gameBoard[x][y].getMoved()){
            castle(list, x, y, -1, gameBoard, notation,validMoveChecker);
            castle(list, x, y, 1, gameBoard, notation,validMoveChecker);
        }

        return list;
    }

    //TODO: cant castle when checked
    public void castle(List<Move> list, int x, int y, int direction, Piece[][]gameBoard,List<String> notation,boolean validMoveChecker){
        if(gameBoard[x][y+direction]==null && gameBoard[x][y+direction+direction]==null){
            if(y+direction+direction+direction<4 && gameBoard[x][y+direction+direction+direction]!=null){
                return;
            }
            int rookSide = 7;
            if(direction==-1){
                rookSide = 0;
            }
            if(gameBoard[x][rookSide] instanceof Rook && gameBoard[x][rookSide].getPlayerPiece()==gameBoard[x][y].getPlayerPiece() && !gameBoard[x][rookSide].getMoved()){
                Piece[][] possiblePosition = this.copy(gameBoard);
                King king = new King(gameBoard[x][y].getPlayerPiece());
                king.setMoved(true);
                possiblePosition[x][y] = null;
                possiblePosition[x][y + direction + direction] = king;

                Rook rook = new Rook(gameBoard[x][rookSide].getPlayerPiece());
                rook.setMoved(true);
                possiblePosition[x][rookSide] = null;
                possiblePosition[x][y + direction] = rook;

                List<String> newNotation = this.generateNewNotation(notation, x, y, x, y + direction + direction);
                Move move = new Move(x, y, x, y + direction + direction, possiblePosition, newNotation);

                if(validMoveChecker && !checkValidCastle(gameBoard,x,y,direction,newNotation.get(newNotation.size()-1))){
                    return;
                }
                list.add(move);

            }
        }
    }


    public boolean checkValidCastle(Piece[][]gameBoard, int x, int y, int direction,String s){
        List<String> notation = Arrays.asList(s);
        List<Move> nextPossibleMoves = getAllPossiblePositions(gameBoard,!gameBoard[x][y].getPlayerPiece(),notation,false);
        List<String> list = new ArrayList<>();
        list.add(getNotation(x,y,x,y,"").split("-",2)[1]);
        list.add(getNotation(x,y,x,y+direction,"").split("-",2)[1]);
        list.add(getNotation(x,y,x,y+direction+direction,"").split("-",2)[1]);

        for(int a=0; a<nextPossibleMoves.size(); a++){
            for(int b=0; b<list.size(); b++){
                if(nextPossibleMoves.get(a).getMoveList().get(nextPossibleMoves.get(a).getMoveList().size()-1).contains(list.get(b))){
                    return false;
                }
            }
        }
        return true;
    }


    public void possibleKingMoves(List<Move> list,int x, int y,int xIncrement, int yIncrement,Piece [][]gameBoard,List<String> notation){
        if(x+xIncrement<gameBoard.length && x+xIncrement>-1 && y+yIncrement<gameBoard[0].length && y+yIncrement>-1 && (gameBoard[x+xIncrement][y+yIncrement]==null || gameBoard[x+xIncrement][y+yIncrement].getPlayerPiece()!=gameBoard[x][y].getPlayerPiece())){
            Piece[][] possiblePosition = this.copy(gameBoard);
            King king = new King(gameBoard[x][y].getPlayerPiece());
            king.setMoved(true);
            possiblePosition[x][y] = null;
            possiblePosition[x+xIncrement][y+yIncrement] = king;
            List<String> newNotation = this.generateNewNotation(notation, x, y, x+xIncrement, y+yIncrement);
            Move move = new Move(x, y, x+xIncrement, y+yIncrement, possiblePosition,newNotation);
            move.setKingCaptured(isEnemyKing(gameBoard,x+xIncrement,y+yIncrement));
            list.add(move);
        }
    }
}
