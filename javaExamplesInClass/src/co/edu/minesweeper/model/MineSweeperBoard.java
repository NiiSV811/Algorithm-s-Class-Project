package co.edu.uptc.test.minesweeper.model;
import java.util.Random;
public class MineSweeperBoard {

    private int numOfMines;
    private char[][] board;
    private char[][] boardMask;
    private int rows;
    private int columns;

    public MineSweeperBoard( int rows, int columns, int numOfMines){

        this.rows = rows;
        this.columns = columns;
        this.board = new char[this.rows][this.columns];
        this.boardMask = this.board;
        this.numOfMines = numOfMines;

    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(){
        for(int indexRow = 0; indexRow < this.rows; indexRow++){
            for(int indexCol = 0; indexCol < this.columns;indexCol++){
                this.board[indexRow][indexCol] = '0';
            }
        }
    }

    public char getBoardPosition(int row, int col){
        return this.board[row][col];
    }

    public void setBoardMaskSquare(int row, int col){
        this.boardMask[row][col] = this.board[row][col];
    }

    public void setBoardMask(){
        for(int indexRow = 0; indexRow < this.rows; indexRow++){
            for(int indexCol = 0; indexCol < this.columns;indexCol++){
                this.board[indexRow][indexCol] = '*';
            }
        }
    }

    public void setMines(){
        Random randomNumber = new Random(); //generate a random Object
        int row = 0;
        int col = 0;
        int iterator = this.numOfMines;
        while (iterator > 0){
            row = randomNumber.nextInt(this.board.length);
            col = randomNumber.nextInt(this.board[row].length);

            if(this.board[row][col] != 'x'){
                this.board[row][col] = 'x';
                iterator--;
            }

        }
    }

    public String printBoard() {
        String stringBoard = "";
        int indexToShow = 0;

        //Set numbers above the board
        stringBoard = stringBoard + "\t\t" + "║\t\t            ";
        for (int numColsIndex = 1; numColsIndex <= this.columns; numColsIndex++) {
            stringBoard = stringBoard  + " "+ numColsIndex  + " ";
        }
        stringBoard = stringBoard + "   ║\n";

        for (int indexRow = 0; indexRow < this.rows; indexRow++) {
            indexToShow = indexRow + 1;
            for (int indexCol = 0; indexCol < this.columns; indexCol++) {
                if (indexCol == 0) {
                    stringBoard = stringBoard + "\t\t" + "║  " + String.format("%02d",indexToShow) + "\t     ";
                }

                stringBoard = stringBoard + " "+ this.boardMask[indexRow][indexCol] + " "; //Printing the character

                //Text Decoration
                if (indexCol == this.columns - 1) {
                    stringBoard = stringBoard + "   ║\n";

                }
            }
        }
        return stringBoard;
    }






}
