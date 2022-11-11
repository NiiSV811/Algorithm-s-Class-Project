package minesweeper.model;
import java.util.Random;

/**
 * This class generates a mine Board, also count dig positions
 * and control the game state. Uses a board to set mines and numbers,
 * uses a mask to play.
 *
 *@author Nicolas Sarmiento Vargas
 *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
 *@version 1.0
 */

public class MineSweeperBoard {
    private char[][] board;
    private char[][] mask;
    private int rows;
    private int columns;
    private int numMines;
    private int freeBoxes;
    private int freeBoxesCounter;
    private boolean isAlive;

    private String gameStatus;


    //Constructor
    public MineSweeperBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        this.board = new char[this.rows][this.columns];
        this.mask = new char[this.rows][this.columns];
    }

    //Set & Get

    //Number of Mines
    public void setNumMines(int numMines) {this.numMines = numMines;}
    public int getNumMines(){return this.numMines;}

    //Free Positions
    public void setFreeBoxes(int freeBoxes){this.freeBoxes = freeBoxes; }
    public int getFreeBoxes(){return this.freeBoxes;}

    // Counter of dig Positions
    public void setFreeBoxesCounter(int counterFreeBoxes){this.freeBoxesCounter = counterFreeBoxes;}
    public int getFreeBoxesCounter(){return this.freeBoxesCounter;}

    // This flag indicate if the user dig in a mine.
    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}
    public boolean getIsAlive(){return this.isAlive;}

    //Shows information about the position, this is modified in the controller.
    public void setGameStatus(String newStatus){this.gameStatus = newStatus;}
    public String getGameStatus(){return this.gameStatus;}

    //Fill the board with zeros.
    public void setBoard(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                this.board[y][x] = '0';
            }
        }
    }

    public char[][] getBoard() {return this.board;}

    //Fill the mask with a pretty character. Use encoding UTF-8 if it's not showing properly.
    public void setMask(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                this.mask[y][x] = '■';
            }
        }
    }
    public char[][] getMask() {return this.mask;}

    public char getPos(int y, int x){return this.board[y][x];}
    public void setMaskPos(int y, int x){
        this.mask[y][x] = this.board[y][x];
    }
    public char getMaskPos(int y, int x){return this.mask[y][x];}

    //Methods

    /**
     * Prints the board, it uses to test and to show the user
     * at the end of each game.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     */
    public void printBoard(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t");
        for(char c : letters){
            System.out.print(c+" ");
        }
        System.out.print("  ╗\n");
        for(int row = 0 ; row < board.length; row++){
            for (int column = 0 ; column < board[row].length; column++){

                //Text Decoration
                if ( column == 0) {
                    System.out.print("\t\t"+"║  " +String.format("%02d",numbers[row])+"\t");
                }

                System.out.print(board[row][column]+ " "); //Printing the character

                //Text Decoration
                if (column == board[row].length - 1) {
                    System.out.print("  ║");

                }
            }
            System.out.println(" ");
        }

        System.out.print("\t\t"+"╚\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");
    }

    //Print Mask
    /**
     * Prints the game mask uses to show at the user
     * the digged positions.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     */
    public void printMask(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t");
        for(char c : letters){
            System.out.print(c+" ");
        }
        System.out.print("  ╗\n");
        for(int row = 0 ; row < board.length; row++){
            for (int column = 0 ; column < board[row].length; column++){

                //Text Decoration
                if ( column == 0) {
                    System.out.print("\t\t"+"║  " +String.format("%02d",numbers[row])+"\t");
                }

                System.out.print(mask[row][column]+ " "); //Printing the character

                //Text Decoration
                if (column == board[row].length - 1) {
                    System.out.print("  ║");

                }
            }
            System.out.println(" ");
        }

        System.out.print("\t\t"+"╚\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");
    }

    //Set Mines
    /**
     * Puts mines randomly in the board
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     *
     */
    public void setMines(){
        Random randGen = new Random();
        int posX = 0;
        int posY = 0;
        int iterator = 0;
        while (iterator < this.numMines){
            posX = randGen.nextInt(this.columns-1);
            posY = randGen.nextInt(this.rows-1);

            if(this.board[posY][posX] == '0'){
                this.board[posY][posX] = 'x';
                iterator++;
            }

        }

    }

    /**
     * Set numbers in every slot, the number is the
     * count of mines around the slot. This method only
     * set the number, but doesn't do the count
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     *
     */
    public void setNumbers(){
        int mineCounter = 0;
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                if(this.board[y][x] != 'x'){
                    mineCounter = minesAround(y, x);
                    this.board[y][x] = (char)(mineCounter + '0');
                }
            }
        }
    }

    /**
     * Count mines around the selected slot, it is private
     * because it uses in the same class.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     *@return the total mines around a slot
     */
    private int minesAround(int posY, int posX){
        int mineCount = 0;
        for(int iy= -1 ;iy <=1; iy++){
            for (int ix= -1; ix <= 1; ix++){
                try {
                    if(this.board[posY+iy][posX+ix] =='x'){
                        mineCount = mineCount + 1;
                    }
                }catch (Exception e){}
            }
        }
        return mineCount;
    }

    /**
     * Dig around a slot if it is 0, and if the around slots
     * are 0, it repeats the operation, if there is no 0 around
     * it only dig around.
     * This method is a recursive method.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     *
     */
    public void unlockAround(int posY, int posX){
        String xStorage = "";
        String yStorage = "";
        for(int iy= -1 ;iy <=1; iy++){
            for (int ix= -1; ix <= 1; ix++){
                try {
                    if(this.getPos(posY + iy, posX + ix) == '0' && this.getMaskPos(posY + iy, posX + ix) == '■'){
                        this.setMaskPos(posY + iy, posX + ix);
                        unlockAround( posY + iy, posX + ix);
                    }else {
                        this.setMaskPos(posY + iy, posX + ix);
                    }

                }catch (Exception e){}
            }
        }

    }

    /**
     * Update the number of dig slots, this is used in
     * every turn
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     *
     */

    public void updateCounter(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                if(this.getMaskPos(y, x) != '■'){
                    this.freeBoxesCounter++;
                }
            }
        }
    }


}
