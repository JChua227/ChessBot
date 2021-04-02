package Decision;

import Pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Material
    Positional (number of moves compared to opponent)
    Bishop pair bonuses
    Castled king bonuses
    Central pawns pushed bonuses
    Early queen movement penalty
    Connected rooks bonuses
    King safety (half open, fully open files next to king, pawn shields)
*/


public class Evaluator{

    private NotationConverter notationConverter = new NotationConverter();

    private static int[][]whiteBishopWorth;
    private static int[][]whitePawnWorth;
    private static int[][]whiteQueenWorth;
    private static int[][]whiteRookWorth;
    private static int[][]whiteKingWorth;
    private static int[][]whiteKnightWorth;

    private static int[][]blackBishopWorth;
    private static int[][]blackPawnWorth;
    private static int[][]blackQueenWorth;
    private static int[][]blackRookWorth;
    private static int[][]blackKingWorth;
    private static int[][]blackKnightWorth;

    public Evaluator(){
        setWhiteBishopWorth();
        setWhitePawnWorth();
        setWhiteQueenWorth();
        setWhiteRookWorth();
        setWhiteKingWorth();
        setWhiteKnightWorth();

        setBlackBishopWorth();
        setBlackPawnWorth();
        setBlackQueenWorth();
        setBlackRookWorth();
        setBlackKingWorth();
        setBlackKnightWorth();
    }

    public void setWhiteBishopWorth(){
        this.whiteBishopWorth = new int[][]{
                {-20, -10, -10, -10, -10, -10, -10, -20},
                {-10, 0, 0, 0, 0, 0, 0, -10},
                {-10, 0, 7, 10, 10, 7, 0, -10},
                {-10, 7, 7, 10, 10, 7, 7, -10},
                {-10, 0, 10, 10, 10, 10, 0, -10},
                {-10, 10,10, 10, 10, 10, 10, -10},
                {-10, 7, 0, 0, 0, 0, 7, -10},
                {-20, 0, 0, 0, 0, 0, 0, -20}};
    }

    public void setWhitePawnWorth(){
        this.whitePawnWorth = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {50, 50, 50, 50, 50, 50, 50, 50},
                {10, 10, 20, 30, 30, 20, 10, 10},
                {5, 5, 10, 22, 22, 10, 5, 5},
                {0, 0, 0, 20, 26, 0, 0, 0},
                {5, -4, -10, 0, 0, -10, -4, 0},
                {5, 10, 10, -20, -20, 10, 10, 5},
                {0, 0, 0, 0, 0, 0, 0, 0}};
    }

    public void setWhiteQueenWorth(){
        this.whiteQueenWorth = new int[][]{
                {-20, -10, -10, -5, -5, -10, -10, -20},
                {-10, 0, 0, 0, 0, 0, 0, -10},
                {-10, 0, 5, 5, 5, 5, 0, -10},
                {-5, 0, 5, 5, 5, 5, 0, -5},
                {0, 0, 5, 5, 5, 5, 0, -5},
                {-10, 5, 5, 5, 5, 5, 0, -10},
                {-10, 0, 5, 0, 0, 0, 0, -10},
                {-20, -10, -10, -5, -5, -10, -10, -20}};
    }

    public void setWhiteRookWorth(){
        this.whiteRookWorth = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {5, 11, 11, 11, 11, 11, 11, 5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {-5, 0, 0, 0, 0, 0, 0, -5},
                {0, 0, 0, 5, 5, 0, 0, 0}};
    }

    public void setWhiteKingWorth(){
        this.whiteKingWorth = new int[][]{
                {-30, -40, -40, -50, -50, -40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-30, -40, -40, -50, -50,-40, -40, -30},
                {-20, -30, -30, -40, -40,-30, -30, -20},
                {-10, -20, -20, -20, -20,-20, -20, -10},
                {20, 20, 0, 0, 0, 0, 20, 20},
                {20, 30, 10, 0, 0, 10, 30, 20}};
    }

    public void setWhiteKnightWorth(){
        this.whiteKnightWorth = new int[][]{
                {-50, -40, -30, -1, -1, -30, -40, -50},
                {-40, -20, 0, 2, 2, 0, -20, -40},
                {-30, 3, 10, 15, 15, 10, 3, -30},
                {-10, 2, 20, 25, 25, 20, 2, -10},
                {-10, 2, 20, 25, 25, 20, 2, -10},
                {-30, 3, 10, 20, 20, 10, 3, -30},
                {-40, -20, 0, 2, 2, 0, -20, -40},
                {-50, -40, -30, -20, -20, -30, -40, -50}};
    }

    public int[][] getWhiteBishopWorth(){
        return this.whiteBishopWorth;
    }


    public int[][] getWhitePawnWorth(){
        return this.whitePawnWorth;
    }

    public int[][] getWhiteQueenWorth(){
        return this.whiteQueenWorth;
    }

    public int[][] getWhiteRookWorth(){
        return this.whiteRookWorth;
    }

    public int[][] getWhiteKingWorth(){
        return this.whiteKingWorth;
    }

    public int[][] getWhiteKnightWorth(){
        return this.whiteKnightWorth;
    }

    public void setBlackBishopWorth(){
        this.blackBishopWorth = swapToBlackPerspective(getWhiteBishopWorth());
    }

    public void setBlackPawnWorth(){
        this.blackPawnWorth = swapToBlackPerspective(getWhitePawnWorth());
    }

    public void setBlackQueenWorth(){
        this.blackQueenWorth = swapToBlackPerspective(getWhiteQueenWorth());
    }

    public void setBlackRookWorth(){
        this.blackRookWorth = swapToBlackPerspective(getWhiteRookWorth());
    }

    public void setBlackKingWorth(){
        this.blackKingWorth = swapToBlackPerspective(getWhiteKingWorth());
    }

    public void setBlackKnightWorth(){
        this.blackKnightWorth = swapToBlackPerspective(getWhiteKnightWorth());
    }

    public int[][] getBlackBishopWorth(){
        return this.blackBishopWorth;
    }


    public int[][] getBlackPawnWorth(){
        return this.blackPawnWorth;
    }

    public int[][] getBlackQueenWorth(){
        return this.blackQueenWorth;
    }

    public int[][] getBlackRookWorth(){
        return this.blackRookWorth;
    }

    public int[][] getBlackKingWorth(){
        return this.blackKingWorth;
    }

    public int[][] getBlackKnightWorth(){
        return this.blackKnightWorth;
    }

    public int[][] swapToBlackPerspective(int[][] array){
        int newArray[][] = new int[array.length][array[0].length];

        int xCounter = 7;
        for(int x=0; x<array.length; x++){
            int yCounter = 7;
            for(int y=0 ;y<array[0].length; y++){
                newArray[xCounter][yCounter] = array[x][y];
                yCounter--;
            }
            xCounter--;
        }
        return newArray;
    }

    public int evaluate(Piece[][] gameBoard){
        int total = 0;
        total += sumStaticPositionAndKingRadius(gameBoard,piecesAroundKing(gameBoard,22));
        total += sumPositionalWorth(gameBoard);
        total += pawnChain(gameBoard);

        return total;
    }

    public int pawnChain(Piece[][] gameBoard){
        int whiteValue = 0;
        int blackValue = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Pawn){
                    if(gameBoard[x][y].getPlayerPiece() && whiteValue==0){
                        whiteValue = getPawnChainWorth(gameBoard,x,y);
                    }
                    else if(!gameBoard[x][y].getPlayerPiece() && blackValue==0){
                        blackValue = getPawnChainWorth(gameBoard,x,y);
                    }
                }
            }
        }
        return whiteValue-blackValue;
    }

    public int getPawnChainWorth(Piece[][] gameBoard, int x, int y){
        int [][]array = new int[gameBoard.length][gameBoard[0].length];
        for(int a=0; a<gameBoard.length; a++){
            for(int b=0; b<gameBoard[0].length; b++){
                if(gameBoard[a][b] instanceof Pawn && gameBoard[a][b].getPlayerPiece()==gameBoard[x][y].getPlayerPiece()){
                    array[a][b]=1;
                }
            }
        }

        return pawnChainWorth(numberOfPawnChainIslands(array));
    }

    public int pawnChainWorth(List<Integer> list){
        int total = 0;
        for(int x=0; x<list.size(); x++){
            total += ((list.get(x)-1)*list.get(x)*(list.get(x)+1))/1.8;
        }
        return total;
    }

    public List<Integer> numberOfPawnChainIslands(int [][]array){
        List<Integer> list = new ArrayList<>();

        for(int x=3; x<array.length-3; x++){
            for(int y=0; y<array[0].length; y++){
                if(array[x][y]!=0){
                    list.add(0);
                    deletePawnChain(list,array,x,y);
                }
            }
        }

        return list;
    }

    public void deletePawnChain(List<Integer> list,int [][]array,int x, int y){
        if(x<0 || x>array.length-1 || y<0 || y>array[0].length-1 || array[x][y]==0){
            return;
        }
        else{
            list.set(list.size()-1,list.get(list.size()-1)+1);
        }

        array[x][y]=0;
        deletePawnChain(list,array,x+1,y+1);
        deletePawnChain(list,array,x-1,y+1);
        deletePawnChain(list,array,x+1,y-1);
        deletePawnChain(list,array,x-1,y-1);
    }

    public List<int[][]> piecesAroundKing(Piece[][] gameBoard, int startingValue){
        int []whiteKingPosition = findingKing(gameBoard,true);
        int []blackKingPosition = findingKing(gameBoard,false);

        int [][]whiteKing = kingRadiusPoints(gameBoard,whiteKingPosition[0], whiteKingPosition[1],startingValue);
        int [][]blackKing = kingRadiusPoints(gameBoard,blackKingPosition[0], blackKingPosition[1],startingValue);

        List<int[][]> kingRadius = Arrays.asList(whiteKing,blackKing);
        return kingRadius;
    }

    public int[] findingKing(Piece[][] gameBoard,boolean player){
        int []kingPosition = new int[2];
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof King && gameBoard[x][y].getPlayerPiece()==player){
                    kingPosition[0]=x;
                    kingPosition[1]=y;
                    return kingPosition;
                }
            }
        }
        return kingPosition;
    }

    public static int[][] kingRadiusPoints(Piece [][]gameBoard, int kingX, int kingY, int valueFromStart){
        int [][]kingRadiusPoints = new int[gameBoard.length][gameBoard[0].length];
        for(int x=0; x<kingRadiusPoints.length; x++){
            for(int y=0; y<kingRadiusPoints[0].length; y++){
                int temp1 = Math.abs(x-kingX);
                int temp2 = Math.abs(y-kingY);
                if(temp1>temp2){
                    kingRadiusPoints[x][y] = valueFromStart-(temp1*3);
                }
                else{
                    kingRadiusPoints[x][y] = valueFromStart-(temp2*3);
                }
            }
        }
        return kingRadiusPoints;
    }

    public Move evaluatePosition(Move move, String nextMove){
        return new Move(move.getGameState(), evaluate(move.getGameState()), nextMove,move.getMoveList());
    }

    public int sumStaticPositionAndKingRadius(Piece [][]gameBoard, List<int[][]>kingRadius){
        int pieceCountWorth = 0;
        int piecePositionToEnemyKing = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y] instanceof Piece){
                    if(gameBoard[x][y].getPlayerPiece()){
                        pieceCountWorth += gameBoard[x][y].getPieceWorth();
                        piecePositionToEnemyKing += kingRadius.get(1)[x][y];
                    }
                    else{
                        pieceCountWorth -= gameBoard[x][y].getPieceWorth();
                        piecePositionToEnemyKing -= kingRadius.get(0)[x][y];
                    }
                }
            }
        }
        return pieceCountWorth+piecePositionToEnemyKing;
    }

    public int sumPositionalWorth(Piece [][]gameBoard){
        int worth = 0;
        for(int x=0; x<gameBoard.length; x++){
            for(int y=0; y<gameBoard[0].length; y++){
                if(gameBoard[x][y]!=null){
                    if(gameBoard[x][y] instanceof Bishop){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhiteBishopWorth()[x][y];
                        else{
                            worth -= getBlackBishopWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Knight){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhiteKnightWorth()[x][y];
                        else{
                            worth -= getBlackKnightWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Pawn){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhitePawnWorth()[x][y];
                        else{
                            worth -= getBlackPawnWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Queen){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhiteQueenWorth()[x][y];
                        else{
                            worth -= getBlackQueenWorth()[x][y];
                        }
                    }
                    else if(gameBoard[x][y] instanceof Rook){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhiteRookWorth()[x][y];
                        else{
                            worth -= getBlackRookWorth()[x][y];
                        }
                    }
                    if(gameBoard[x][y] instanceof King){
                        if(gameBoard[x][y].getPlayerPiece())
                            worth += getWhiteKingWorth()[x][y];
                        else{
                            worth -= getBlackKingWorth()[x][y];
                        }
                    }
                }
            }
        }

        return worth;
    }



    public boolean checkTie(Piece[][] gameState){
        for(int x=0; x<gameState.length; x++){
            for(int y=0; y<gameState[0].length; y++){
                if(gameState[x][y]!=null){
                    if(!(gameState[x][y] instanceof King)){
                        return false;
                    }
                }
            }
        }

        return true;
    }


}